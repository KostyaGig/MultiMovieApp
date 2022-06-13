package ru.zinoview.movies.data.cloud

import com.google.gson.annotations.SerializedName
import ru.zinoview.core.Mapper
import ru.zinoview.movies.core.*
import java.lang.IllegalStateException

interface CloudMovies {

    class Base(
        @SerializedName("films")
        private val movies: ArrayList<CloudMovie.Base>
    ) : CloudMovies, Mapper<Triple<ToCloudMovieMapper,Description,Description>, List<CloudMovie>> {

        override fun map(data: Triple<ToCloudMovieMapper,Description,Description>)
            = movies.map { movie -> movie.map(data.first,data.second,data.third) }
    }

    interface CloudMovie : BaseMovie {

        fun <T> map(mapper: MovieMapper<T>,description: Description,emptyDescription: Description) : T = throw IllegalStateException("CloudMovie -> map() with two arguments")
        override fun <T> map(mapper: MovieMapper<T>) : T = throw IllegalStateException("CloudMovie -> map() with a single argument")

        class Base(
            @SerializedName("id")
            private val id: Int,
            @SerializedName("name")
            private val title: String,
            @SerializedName("year")
            private val year: Int,
            @SerializedName("image_url")
            private val image: String?,
            @SerializedName("description")
            private val description: String?,
        ) : CloudMovie {

            override fun <T> map(mapper: MovieMapper<T>, shortDescription: Description,emptyDescription: Description): T {
                val mainData = if (image == null) {
                    MainMovieData.EmptyImage(id.toString(),title)
                } else {
                    MainMovieData.WithImage(id.toString(), image, title)
                }
                val extraData = if (description == null) {
                    ExtraMovieData.EmptyDescription(emptyDescription.map(""),year.toString())
                } else {
                    ExtraMovieData.WithDescription(this.description,shortDescription.map(this.description), year.toString())
                }
                return mapper.map(mainData, extraData)
            }

        }

        class Mapped(
            private val mainData: MainMovieData,
            private val extraData: ExtraMovieData
        ) : CloudMovie {
            override fun <T> map(mapper: MovieMapper<T>) = mapper.map(mainData,extraData)
        }
    }
}