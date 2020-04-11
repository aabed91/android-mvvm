package com.example.androidmvvm.ui.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.example.androidmvvm.R
import com.example.androidmvvm.base.BaseFragment
import com.example.androidmvvm.databinding.HomeFragmentBinding

class HomeFragment : BaseFragment<HomeViewModel,HomeFragmentBinding>(HomeViewModel::class.java) {
    override fun getLayoutRes(): Int {
        return R.layout.home_fragment
    }

    override fun getViewM(): HomeViewModel {
        return super.getViewModelFromFactory {HomeViewModel(1)}
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mBinding.lifecycleOwner = this

        mBinding.viewModel = viewModel

        viewModel.data.observe(viewLifecycleOwner, Observer {
            println(it)
        })
    }
}
