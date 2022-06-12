package ru.zinoview.multimovieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

        viewModel.movies()

        viewModel.observe(this) { uiMoves ->
            Log.d("zinoviewk",uiMoves.toString())
        }

    }

}