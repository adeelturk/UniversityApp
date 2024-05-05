package com.turk.universityapp.nav

import com.turk.dtos.model.University
import com.turk.universitydetails.nav.UniversityDetailsNav
import com.turk.universitylisting.nav.UniversityListNav
import javax.inject.Inject


class Navigator @Inject constructor() : UniversityListNav, UniversityDetailsNav {

    private var mainRouteHandler : MainRouteHandler?=null

    fun setupNavController(navC : MainRouteHandler){
        mainRouteHandler=navC
    }

    override fun moveToUniversityDetail(selectedUniversity: University) {
        mainRouteHandler?.moveToUniversityDetail(selectedUniversity)
    }

    override fun openUniversityList() {
        mainRouteHandler?.openUniversityList()
    }
}