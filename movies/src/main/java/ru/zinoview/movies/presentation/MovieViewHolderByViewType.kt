package ru.zinoview.movies.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import ru.zinoview.coreuimodule.ViewHolderByViewType
import ru.zinoview.movies.databinding.FailureItemBinding
import ru.zinoview.movies.databinding.MovieItemBinding
import ru.zinoview.movies.databinding.ProgressItemBinding

interface MovieViewHolderByViewType : ViewHolderByViewType<UiMovie> {

    class Base(
        private val listener: UiMovieItemClickListener = UiMovieItemClickListener.Empty
    ) : MovieViewHolderByViewType {

        override fun viewType(item: UiMovie) = when (item) {
            is UiMovie.Progress -> PROGRESS
            is UiMovie.Base -> BASE
            is UiMovie.Failure -> FAILURE
            else -> throw IllegalArgumentException("MovieItemToIntViewTypeMapper.Base viewType() doesn't process $item")
        }

        override fun viewHolder(viewType: Int,inflater: LayoutInflater,parent: ViewGroup) = when(viewType) {
            PROGRESS -> MoviesAdapter.Base.ProgressViewHolder(
                ProgressItemBinding.inflate(inflater,parent ,false)
            )
            FAILURE -> MoviesAdapter.Base.FailureViewHolder(
                FailureItemBinding.inflate(inflater,parent ,false)
            )
            BASE -> MoviesAdapter.Base.SuccessViewHolder(
                MovieItemBinding.inflate(inflater,parent ,false),
                listener
            )
            else -> throw IllegalArgumentException("MovieItemToIntViewTypeMapper.Base doesn't viewHolder() process $viewType")
        }

        private companion object {
            private const val PROGRESS = 1
            private const val FAILURE = 2
            private const val BASE = 3
        }

    }
}