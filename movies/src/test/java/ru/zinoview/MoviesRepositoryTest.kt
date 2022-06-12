package ru.zinoview


import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import ru.zinoview.movies.core.Movie
import ru.zinoview.movies.data.MoviesRepository

class MoviesRepositoryTest {

    private lateinit var repository: MoviesRepository<List<TestMovie>>

    @Before
    fun setUp() {
        repository = TestMoviesRepository()
    }

    @Test
    fun test_success_fetch_movies() = runBlocking {
        val expected = listOf<TestMovie>(
            TestMovie.Base("1", "TMNT.jpg", "TMNT", "TMNT description", "2003"),
            TestMovie.Base("2", "Bear.jpg", "Bear", "Bear description", "1999"),
            TestMovie.Base("3", "1_plus_1.jpg", "1 + 1", "1_plus_1 description", "2020")
        )

        val actual = repository.data()
        assertEquals(expected, actual)
    }

    @Test
    fun test_failure_fetch_movie_no_connection() = runBlocking {
        val expected = listOf(TestMovie.Failure("No connection"))
        repository.data()
        val actual = repository.data()
        assertEquals(expected, actual)
    }


    inner class TestMoviesRepository : MoviesRepository<List<TestMovie>> {

        private var isSuccess = true

        override suspend fun data(): List<TestMovie> {
            return if (isSuccess) {
                isSuccess = false
                listOf<TestMovie>(
                    TestMovie.Base("1", "TMNT.jpg", "TMNT", "TMNT description", "2003"),
                    TestMovie.Base("2", "Bear.jpg", "Bear", "Bear description", "1999"),
                    TestMovie.Base("3", "1_plus_1.jpg", "1 + 1", "1_plus_1 description", "2020")
                )
            } else {
                isSuccess = true
                listOf(TestMovie.Failure("No connection"))
            }
        }
    }

    interface  TestMovie : Movie {

        data class Base(
            private val id: String,
            private val image: String,
            private val title: String,
            private val description: String,
            private val year: String
        ) : TestMovie

        data class Failure(
            private val exception: String
        ) : TestMovie
    }

}