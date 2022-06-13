package ru.zinoview.movies.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import ru.zinoview.core.MovieApplication
import ru.zinoview.coremoviemodule.UiDetailBundle
import ru.zinoview.coreuimodule.BaseFragment
import ru.zinoview.movies.R
import ru.zinoview.movies.databinding.MoviesFragmentBinding
import ru.zinoview.movies.presentation.di.MoviesComponent
import ru.zinoview.navigation.Finish
import ru.zinoview.navigation.Navigation

class MoviesFragment  : BaseFragment<MoviesFragmentBinding>(R.layout.movies_fragment) {

    private val componentViewModel: MoviesComponentViewModel.Base by viewModels()

    private val factory by lazy{
        val component = (requireActivity().application as MovieApplication).component(MoviesScreen) as MoviesComponent
        componentViewModel.moviesViewModelFactory(component)
    }

    private val viewModel: MoviesViewModel.Base by viewModels({ this },{ factory})

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.movies()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // todo move
        val adapter = MoviesAdapter.Base(
            UiMovieDiffUtilCallback(),
            MovieViewHolderByViewType.Base(
                UiMovieItemClickListener.Base(
                    requireActivity() as Navigation,
                    ToDetailMovieMapper.Base(
                        ToMovieArgumentsMapper.UiDetailMovie()
                    ),
                    UiDetailBundle.Base()
                )
            )
        )

        binding.moviesRecView.adapter = adapter

        val layoutManager = LayoutManager.Base(requireContext())
        viewModel.observe(this) { uiMovies ->
            Log.d("zinoviewk","observe $uiMovies")
            uiMovies.updateLayoutManager(binding.moviesRecView,layoutManager)
            uiMovies.show(adapter)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("zinoviewk","ondestroyview")
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup
    ) = MoviesFragmentBinding.inflate(layoutInflater, container, false)

    override fun back() = (requireActivity() as Finish).finish()

}