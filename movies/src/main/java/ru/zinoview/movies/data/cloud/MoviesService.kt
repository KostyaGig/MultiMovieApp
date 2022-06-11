package ru.zinoview.movies.data.cloud

import retrofit2.http.GET

interface MoviesService {

    @GET("sequeniatesttask/films.json")
    suspend fun movies(): CloudMovies.Base
}