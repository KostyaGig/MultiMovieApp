package ru.zinoview.movies.presentation

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import ru.zinoview.coreuimodule.ViewWrapper

interface ImageViewWrapper : ViewWrapper<String> {

    override fun show(data: String) = Unit
    class Base(
        private val image: ImageView
    ) : ImageViewWrapper {

        override fun show(url: String) {
            Glide.with(image)
                .load(url)
                .placeholder(ru.zinoview.R.drawable.ic_launcher_background)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(image)
        }
    }

    object Empty : ImageViewWrapper
}