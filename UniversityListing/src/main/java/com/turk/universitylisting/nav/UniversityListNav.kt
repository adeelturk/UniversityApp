package com.turk.universitylisting.nav

import com.turk.dtos.model.University

interface UniversityListNav {

    fun moveToUniversityDetail(selectedUniversity: University)
}