package ru.zinoview


import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import ru.zinoview.core.Mapper
import ru.zinoview.movies.core.BaseMovies
import ru.zinoview.movies.core.Movie
import ru.zinoview.movies.core.MoviesMapper
import java.lang.IllegalStateException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class MoviesMapperTest {

    private lateinit var mapper: MoviesMapper<TestDomainMovies,Exception>

    @Before
    fun setUp() {
        mapper = TestMoviesMapper(
            TestDataToDomainExceptionMapper()
        )
    }

    @Test
    fun test_success_map_data_to_domain() {
        val data = TestDataMovies.Success(
            listOf<MoviesRepositoryTest.TestMovie>(
                MoviesRepositoryTest.TestMovie.Base("1", "TMNT.jpg", "TMNT", "TMNT description", "2003"),
                MoviesRepositoryTest.TestMovie.Base("2", "Bear.jpg", "Bear", "Bear description", "1999"),
                MoviesRepositoryTest.TestMovie.Base("3", "1_plus_1.jpg", "1 + 1", "1_plus_1 description", "2020")
            )
        )
        val expected = TestDomainMovies.Success(
            listOf<MoviesRepositoryTest.TestMovie>(
                MoviesRepositoryTest.TestMovie.Base("1", "TMNT.jpg", "TMNT", "TMNT description", "2003"),
                MoviesRepositoryTest.TestMovie.Base("2", "Bear.jpg", "Bear", "Bear description", "1999"),
                MoviesRepositoryTest.TestMovie.Base("3", "1_plus_1.jpg", "1 + 1", "1_plus_1 description", "2020")
            )
        )
        val actual = data.map(mapper)
        assertEquals(expected, actual)
    }

    @Test
    fun test_failure_map_data_domain() {
        var data = TestDataMovies.Failure(UnknownHostException())
        var expected = TestDomainMovies.Failure(TestDomainException.NoConnection)
        var actual = data.map(mapper)

        assertEquals(expected, actual)

        data = TestDataMovies.Failure(SocketTimeoutException())
        expected = TestDomainMovies.Failure(TestDomainException.LongConnection)
        actual = data.map(mapper)

        assertEquals(expected, actual)

        data = TestDataMovies.Failure(IllegalStateException())
        expected = TestDomainMovies.Failure(TestDomainException.SomethingWentWrong)
        actual = data.map(mapper)

        assertEquals(expected, actual)
    }

    sealed class TestDataMovies : BaseMovies<Exception> {

        data class Success(
            private val movies: List<MoviesRepositoryTest.TestMovie>
        ) : TestDataMovies() {
            override fun <T> map(mapper: MoviesMapper<T, Exception>) = mapper.map(movies)
        }

        data class Failure(
            private val exception: Exception
        ) : TestDataMovies() {
            override fun <T> map(mapper: MoviesMapper<T, Exception>) = mapper.map(exception)
        }
    }

    sealed class TestDomainMovies {

        data class Success(
            private val movies: List<Movie>
        ) : TestDomainMovies()

        data class Failure(
            private val exception: TestDomainException
        ) : TestDomainMovies()
    }

    abstract class TestDomainException {

        object NoConnection : TestDomainException()

        object LongConnection : TestDomainException()

        object SomethingWentWrong : TestDomainException()
    }

    inner class TestMoviesMapper(
        private val mapper: TestDataToDomainExceptionMapper
    ) : MoviesMapper<TestDomainMovies,Exception> {
        override fun map(movies: List<Movie>)
            = TestDomainMovies.Success(movies)

        override fun map(error: Exception)
            = TestDomainMovies.Failure(mapper.map(error))
    }

    class TestDataToDomainExceptionMapper : Mapper<Exception,TestDomainException> {
        override fun map(src: Exception): TestDomainException {
            return when(src) {
                is UnknownHostException -> TestDomainException.NoConnection
                is SocketTimeoutException -> TestDomainException.LongConnection
                else -> TestDomainException.SomethingWentWrong
            }
        }

    }
}