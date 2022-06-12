package ru.zinoview.multimovieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.zinoview.movies.presentation.MovieViewHolderByViewType
import ru.zinoview.movies.presentation.MoviesAdapter
import ru.zinoview.movies.presentation.UiMovieDiffUtilCallback
import ru.zinoview.multimovieapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        (application as MovieApp).viewModel(this)
    }

    private var nullBinding: ActivityMainBinding? = null
    private val binding by lazy { checkNotNull(nullBinding) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nullBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(nullBinding?.root)

        val adapter = MoviesAdapter.Base(
            UiMovieDiffUtilCallback(),
            MovieViewHolderByViewType.Base()
        )

        binding.moviesRecView.adapter = adapter

        viewModel.observe(this) { uiMoves ->
            uiMoves.show(adapter)
        }

        viewModel.movies()

    }

}