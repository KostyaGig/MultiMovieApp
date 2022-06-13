package ru.zinoview.movies.presentation

import ru.zinoview.coreuimodule.Adapter
import ru.zinoview.coreuimodule.BaseViewHolder
import ru.zinoview.movies.databinding.FailureItemBinding
import ru.zinoview.movies.databinding.MovieItemBinding
import ru.zinoview.movies.databinding.ProgressItemBinding

interface MoviesAdapter : Adapter<UiMovie> {

    class Base(
        callback: UiMovieDiffUtilCallback,
        viewHolderByViewType: MovieViewHolderByViewType
    ) : Adapter.Base<UiMovie,UiMovie>(
        callback,viewHolderByViewType
    ),MoviesAdapter {

        class ProgressViewHolder(
            binding: ProgressItemBinding
        ) : BaseViewHolder<UiMovie>(binding.root)

        class FailureViewHolder(
            private val binding: FailureItemBinding
        ) : BaseViewHolder<UiMovie>(binding.root) {

            override fun bind(item: UiMovie) = item.bind(
                Pair(
                    listOf(TextViewWrapper.Error(binding.errorMessageTv)),
                    ImageViewWrapper.Empty
                )
            )
        }

        class SuccessViewHolder(
            private val binding: MovieItemBinding
        ) : BaseViewHolder<UiMovie>(binding.root) {

            override fun bind(item: UiMovie) = item.bind(
                Pair(
                    listOf(
                        TextViewWrapper.Title(binding.movieTitle),
                        TextViewWrapper.Description(binding.movieDescription)
                    ),
                    ImageViewWrapper.Base(binding.movieImage)
                )
            )
        }
    }
}