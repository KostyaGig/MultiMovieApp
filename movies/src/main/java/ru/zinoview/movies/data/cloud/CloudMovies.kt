package ru.zinoview.movies.data.cloud

import com.google.gson.annotations.SerializedName
import ru.zinoview.core.Mapper
import ru.zinoview.movies.core.*

interface CloudMovies {

    class Base(
        @SerializedName("films")
        private val movies: ArrayList<CloudMovie.Base>
    ) : CloudMovies, Mapper<ToCloudMovieMapper, List<CloudMovie>> {

        override fun map(mapper: ToCloudMovieMapper) = movies.map { movie -> movie.map(mapper) }
    }

    interface CloudMovie : BaseMovie {

        class Base(
            @SerializedName("id")
            private val id: Int,
            @SerializedName("name")
            private val title: String,
            @SerializedName("year")
            private val year: Int,
            @SerializedName("image_url")
            private val image: String,
            @SerializedName("description")
            private val description: String,
        ) : CloudMovie {

            override fun <T> map(mapper: MovieMapper<T>) = mapper.map(
                MainMovieData.Base(id.toString(), image, title),
                ExtraMovieData.Base(description, year.toString())
            )
        }

        class Mapped(
            private val mainData: MainMovieData,
            private val extraData: ExtraMovieData
        ) : CloudMovie {
            override fun <T> map(mapper: MovieMapper<T>) = mapper.map(mainData,extraData)
        }
    }
}