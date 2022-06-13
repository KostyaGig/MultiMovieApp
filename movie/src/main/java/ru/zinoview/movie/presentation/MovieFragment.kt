package ru.zinoview.movie.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import ru.zinoview.core.MovieApplication
import ru.zinoview.coreuimodule.BaseFragment
import ru.zinoview.movie.R
import ru.zinoview.movie.databinding.MovieFragmentBinding
import ru.zinoview.movie.presentation.di.MovieComponent

class MovieFragment : BaseFragment<MovieFragmentBinding>(R.layout.movie_fragment) {

    private val componentViewModel: MovieComponentViewModel by viewModels()

    private val factory by lazy {
        val component = (requireActivity().application as MovieApplication).component(MovieScreen) as MovieComponent
        componentViewModel.movieViewModelFactory(component)
    }

    private val viewModel: MovieViewModel by viewModels({this},{factory})

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null)  {
            val movie = UiDetailBundle.Base(UiDetailBundleWrapper.Base(requireArguments()))
            viewModel.map(movie.read())
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.observe(this) { uiDetailMovie ->
            Log.d("zinoviewk",uiDetailMovie.toString())
        }
    }


    override fun initBinding(inflater: LayoutInflater, container: ViewGroup)
        = MovieFragmentBinding.inflate(inflater,container,false)
}