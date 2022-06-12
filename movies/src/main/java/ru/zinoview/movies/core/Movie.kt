package ru.zinoview.movies.core

interface Movie : BaseMovie {

    class Base(
        private val mainMovieInfo: MainMovieData,
        private val extraMovieInfo: ExtraMovieData
    ) : Movie, BaseMovie {

        override fun <T> map(mapper: MovieMapper<T>) = mapper.map(
            mainMovieInfo, extraMovieInfo
        )
    }
}