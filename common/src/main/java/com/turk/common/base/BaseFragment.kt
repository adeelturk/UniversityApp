package com.turk.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ProgressBar
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.turk.common.R
import com.turk.common.error.ErrorEntity
import com.turk.common.extension.invisible
import com.turk.common.extension.visible
import kotlinx.coroutines.launch


/**
 * base class for all Fragments provide common functionality
 *
 */
abstract class BaseFragment<ViewBinding:ViewDataBinding,STATE:ViewState> :
    Fragment() {


    protected lateinit var binding: ViewBinding
    protected var progressBar: ProgressBar? = null


    fun launchOnLifecycleScope(execute: suspend () -> Unit) {
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            execute()
        }
    }
    /**
     * This method provide visibility of progress bar [showProgress]
     * and block the Screen to be touchable if pass  true to the [lockScreen]
     */
    protected fun showProgress(showProgress: Boolean, lockScreen: Boolean) {
        if (showProgress) {
            progressBar?.visible()

        } else {
            progressBar?.invisible()

        }
        if (lockScreen) {
            activity?.window?.setFlags(
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
            )
        } else {
            activity?.window?.clearFlags(
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
            )
        }
    }



    //Show Toast Message for Testing purposes
    open fun showMessage(messageBody: String) {
        Toast.makeText(context, messageBody, Toast.LENGTH_SHORT).show()
    }


    // Error handling
    open fun handleFailure(errorEntity: ErrorEntity?) {

        showProgress(false, lockScreen = false)
        when (errorEntity) {
            is ErrorEntity.AuthError -> showMessage(
                getString(R.string.failure_authorization)
            )
            is ErrorEntity.Forbidden -> showMessage(getString(R.string.failure_forbidden))
            is ErrorEntity.InternalServerError -> showMessage(
                getString(R.string.failure_forbidden)
            )
            is ErrorEntity.BadRequest -> showMessage(getString(R.string.failure_bad_request))
            is ErrorEntity.NotFound -> showMessage(getString(R.string.failure_not_found))
            is ErrorEntity.AndroidError -> showMessage(getString(R.string.failure_android_error))
            is ErrorEntity.UnSupportedMediaType -> showMessage(getString(R.string.failure_unsupportedmedia))
            is ErrorEntity.MalFormedJson -> showMessage(getString(R.string.failure_malformedJson))
            is IllegalStateException -> showMessage(getString(R.string.failure_malformedJson))
            is ErrorEntity.JsonSyntaxException -> showMessage(getString(R.string.failure_malformedJson))
            is ErrorEntity.UniqueConstraintError -> showMessage(getString(R.string.failure_unique_constraint))
            is ErrorEntity.ServerError -> showMessage(getString(R.string.failure_server_error))
            is ErrorEntity.NetworkConnection -> showMessage(getString(R.string.failure_network_connection))
            is ErrorEntity.ApiRateLimitExceeded -> showMessage(errorEntity.message)
            is ErrorEntity.Default -> {}
            else -> showMessage(getString(R.string.something_went_wrong))
        }
    }


    //My Abstracts
    protected abstract fun layoutResourceId(): Int
    protected open fun attachListeners() {}
    abstract fun getViewModel(): BaseViewModel<STATE>

    abstract fun initialize(savedInstanceState: Bundle?)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listenViewState()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, layoutResourceId(), container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize(savedInstanceState)
        attachListeners()

    }

    private fun listenViewState() {

        lifecycleScope.launch {
            // The block passed to repeatOnLifecycle is executed when the lifecycle
            // is at least STARTED and is cancelled when the lifecycle is STOPPED.
            // It automatically restarts the block when the lifecycle is STARTED again.
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                getViewModel().viewState.collect {
                    handleViewState(it)
                }


            }
        }

    }

    abstract fun handleViewState(state:ViewState)




}