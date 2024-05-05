package com.turk.universitydetails.state

import com.turk.common.base.ViewState

sealed class UniversityDetailsState: ViewState {

    object DEFAULT : UniversityDetailsState()
}