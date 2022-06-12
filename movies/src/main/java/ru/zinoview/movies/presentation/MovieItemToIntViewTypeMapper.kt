package ru.zinoview.movies.presentation

import ru.zinoview.coreuimodule.ItemToIntViewTypeMapper

interface MovieItemToIntViewTypeMapper : ItemToIntViewTypeMapper<UiMovie> {

    class Base : MovieItemToIntViewTypeMapper {

        override fun map(item: UiMovie): Int {
            return when(item) {
                is UiMovie.Progress -> 1
                is UiMovie.Base -> 2
                is UiMovie.Failure -> 3
                else -> throw IllegalArgumentException("MovieItemToIntViewTypeMapper.Base doesn't process $item")
            }
        }
    }
}