package ru.zinoview.multimovieapp

import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import ru.zinoview.coreuimodule.BaseFragment
import ru.zinoview.coreuimodule.BundleWrapper
import ru.zinoview.navigation.Finish
import ru.zinoview.navigation.Navigation


class MainActivity : AppCompatActivity(), Navigation, Finish {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
    }

    // todo make back nav
//    override fun onBackPressed() {
//        val fragment = navHostFragment!!.childFragmentManager.fragments.first()
//        if (fragment is  BaseFragment<*>) {
//            fragment.back()
//        }
//    }

    override fun finish() = super.finish()

    override fun navigate(bundle: BundleWrapper<*>, actionId: Int) {
//        if (bundle is BundleWrapper.Empty) {
//            findNavController(R.id.host_fragment).navigate(ru.zinoview.navigation.R.id.moviesFragment)
//        } else {
//            findNavController(R.id.host_fragment).navigate(actionId,bundle.bundle())
//        }
    }

}
