package com.turk.universitylisting

import androidx.lifecycle.viewModelScope
import com.turk.business.UniversityUseCase
import com.turk.common.base.BaseViewModel
import com.turk.universitylisting.state.UniversityState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UniversityViewmodel @Inject constructor(private val universityUseCase: UniversityUseCase) :
    BaseViewModel<UniversityState>(UniversityState.DEFAULT) {

    fun fetchUniversities() {
        viewModelScope.launch {

            universityUseCase().collect {
                it.either({
                    handleFailure(it)
                }, {
                    emitViewState(UniversityState.SUCCESS(it))
                }, {
                    emitViewState(UniversityState.Loading)
                })

            }

        }
    }

}