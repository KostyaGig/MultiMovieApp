package ru.zinoview.movies.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import ru.zinoview.core.MovieApplication
import ru.zinoview.coreuimodule.BaseFragment
import ru.zinoview.movies.R
import ru.zinoview.movies.databinding.MoviesFragmentBinding
import ru.zinoview.movies.presentation.di.MoviesComponent

class MoviesFragment  : BaseFragment<MoviesFragmentBinding>(R.layout.movies_fragment) {

    private val componentViewModel: MoviesComponentViewModel.Base by viewModels()

    private val factory by lazy{
        val component = (requireActivity().application as MovieApplication<MoviesComponent>).component()
        componentViewModel.moviesViewModelFactory(component)
    }

    private val viewModel: MoviesViewModel.Base by viewModels({ this },{ factory})

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MoviesAdapter.Base(
            UiMovieDiffUtilCallback(),
            MovieViewHolderByViewType.Base()
        )

        binding.moviesRecView.adapter = adapter

        val layoutManager = LayoutManager.Base(requireContext())
        viewModel.observe(this) { uiMoves ->
            uiMoves.updateLayoutManager(binding.moviesRecView,layoutManager)
            uiMoves.show(adapter)
        }

        viewModel.movies()
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup
    ) = MoviesFragmentBinding.inflate(layoutInflater, container, false)
}