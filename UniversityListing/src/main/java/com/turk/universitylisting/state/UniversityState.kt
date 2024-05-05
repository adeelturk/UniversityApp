package com.turk.universitylisting.state

import com.turk.common.base.ViewState
import com.turk.dtos.model.University

sealed class UniversityState: ViewState {

    object DEFAULT : UniversityState()
    object Loading : UniversityState()
    data class SUCCESS(val data:List<University>): UniversityState()
}