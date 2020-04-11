package com.example.androidmvvm.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.androidmvvm.util.showErrorMessageDialog
import com.example.androidmvvm.util.showMessageDialog


abstract class BaseFragment<VM : BaseViewModel, DB : ViewDataBinding>(private val mViewModelClass: Class<VM>) : Fragment() {
    lateinit var viewModel: VM
    open lateinit var mBinding: DB
    fun init(inflater: LayoutInflater, container: ViewGroup) {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
    }

    open fun init() {}
    @LayoutRes
    abstract fun getLayoutRes(): Int

    abstract fun getViewM(): VM

    fun getViewModelFromFactory(creatorFactory: (() -> VM)? = null): VM {

        return if (creatorFactory == null) {
            ViewModelProviders.of(this).get(mViewModelClass)
        } else {
            ViewModelProviders.of(this,
                BaseViewModelFactory(
                    creatorFactory
                )
            )
                .get(mViewModelClass)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = getViewM()


        viewModel.errorMessage.observe(this, Observer {
            println("Error Message")
            if(!it.isNullOrBlank()){
                showMessageDialog(it)
                viewModel.resetErrorMessage()
            }
        })


        viewModel.showFailureDialog.observe(this, Observer {
            if(it){
                showErrorMessageDialog()
                viewModel.resetFailureDialog()
            }
        })

        viewModel.onBack.observe(this, Observer {
            if(it){
                findNavController().navigateUp()
                viewModel.resetOnBack()
            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        init(inflater, container!!)
        init()
        super.onCreateView(inflater, container, savedInstanceState)

        return mBinding.root
    }

    open fun refresh() {}
}