package ru.zinoview.coreuimodule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<B : ViewBinding>(
    @LayoutRes id: Int
) : Fragment(id), Back {

    private var _binding: B? = null

    protected val binding by lazy {
        checkNotNull(_binding)
    }
    abstract fun initBinding(inflater: LayoutInflater,container: ViewGroup) : B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = initBinding(inflater,container!!)
        return _binding?.root
    }
}