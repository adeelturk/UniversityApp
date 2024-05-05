package com.turk.universityapp.nav

import android.os.Bundle
import androidx.navigation.NavController
import com.turk.dtos.model.University
import com.turk.universityapp.R
import com.turk.universitydetails.nav.UniversityDetailsNav
import com.turk.universitylisting.nav.UniversityListNav
import javax.inject.Inject

interface MainRouteHandler  {

     fun moveToUniversityDetail(selectedUniversity: University)

     fun openUniversityList()
}