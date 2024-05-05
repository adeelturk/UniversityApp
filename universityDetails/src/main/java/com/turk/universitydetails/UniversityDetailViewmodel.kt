package com.turk.universitydetails

import com.turk.business.UniversityUseCase
import com.turk.common.base.BaseViewModel
import com.turk.universitydetails.state.UniversityDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UniversityDetailViewmodel @Inject constructor(private val universityUseCase: UniversityUseCase) :
    BaseViewModel<UniversityDetailsState>(UniversityDetailsState.DEFAULT) {


}