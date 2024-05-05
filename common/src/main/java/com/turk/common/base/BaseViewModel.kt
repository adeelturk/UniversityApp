package com.turk.common.base

import androidx.lifecycle.ViewModel
import com.turk.common.error.ErrorEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


abstract class BaseViewModel<STATE:ViewState>(defaultState:ViewState) :
    ViewModel(){



    /**
     * Handle the errors of the view model
     */
    private val _errorEntity: MutableStateFlow<ErrorEntity> = MutableStateFlow(ErrorEntity.Default)
    val errorEntity: StateFlow<ErrorEntity> =_errorEntity.asStateFlow()

    private val _viewState: MutableStateFlow<ViewState> = MutableStateFlow(defaultState)
    val viewState: StateFlow<ViewState> =_viewState.asStateFlow()


    //endregion

    //region Failure Handling
    protected fun handleFailure(errorEntity: ErrorEntity) {
        this._errorEntity.value=errorEntity
    }
    //endregion


    fun emitViewState(state: ViewState){
        _viewState.value=state
    }

}