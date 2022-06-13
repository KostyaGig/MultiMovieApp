package ru.zinoview.movies.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.zinoview.core.MovieApplication
import ru.zinoview.movies.R
import ru.zinoview.movies.databinding.MoviesFragmentBinding
import ru.zinoview.movies.presentation.di.MoviesComponent

class MoviesFragment  : Fragment(R.layout.movies_fragment) {

    private val componentViewModel by lazy {
        val factory = MoviesComponentViewModelFactory.Base()
        ViewModelProvider(this,factory)[MoviesComponentViewModel.Base::class.java]
    }

    // todo try to use by viewModels()
    private val viewModel by lazy {
        val component = (requireActivity().application as MovieApplication<MoviesComponent>).component()
        val factory = componentViewModel.moviesViewModelFactory(component)
        ViewModelProvider(this,factory)[MoviesViewModel.Base::class.java]
    }

    private var nullBinding: MoviesFragmentBinding? = null
    private val binding by lazy { checkNotNull(nullBinding) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        nullBinding =  MoviesFragmentBinding.inflate(layoutInflater, container, false)
        return nullBinding?.root
    }

    // todo refactor
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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