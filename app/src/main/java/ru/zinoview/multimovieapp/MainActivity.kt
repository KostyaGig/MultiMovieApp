package ru.zinoview.multimovieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import ru.zinoview.movies.presentation.*
import ru.zinoview.movies.presentation.di.MoviesComponent
import ru.zinoview.multimovieapp.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val componentViewModel by lazy {
        val factory = MoviesComponentViewModelFactory.Base()
        ViewModelProvider(this,factory)[MoviesComponentViewModel.Base::class.java]
    }

    private val viewModel by lazy {
        val component = (application as MovieApp).moviesComponent
        val factory = componentViewModel.moviesViewModelFactory(component)
        ViewModelProvider(this,factory)[MoviesViewModel.Base::class.java]
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