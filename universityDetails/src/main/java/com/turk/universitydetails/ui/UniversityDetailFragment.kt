package com.turk.universitydetails.ui

import android.os.Build
import android.os.Build.VERSION
import android.os.Bundle
import androidx.fragment.app.viewModels
import com.turk.common.base.BaseFragment
import com.turk.common.base.ViewState
import com.turk.dtos.model.University
import com.turk.universitydetails.R
import com.turk.universitydetails.UniversityDetailViewmodel
import com.turk.universitydetails.databinding.UniversityDetailFragmentBinding
import com.turk.universitydetails.nav.UniversityDetailsNav
import com.turk.universitydetails.state.UniversityDetailsState
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UniversityDetailFragment : BaseFragment<UniversityDetailFragmentBinding,UniversityDetailsState>() {

    @Inject
    lateinit var universityDetailsNav: UniversityDetailsNav

    private val universityViewModel: UniversityDetailViewmodel by viewModels()

    override fun layoutResourceId(): Int= R.layout.university_detail_fragment

    override fun getViewModel() =universityViewModel

    override fun handleViewState(state: ViewState) {
    }

    override fun initialize(savedInstanceState: Bundle?) {
        val selectedUniv= arguments?.getParcelable<University>("selectedUniv")
        binding.universityData=selectedUniv
        binding.imageView.setOnClickListener{
            universityDetailsNav.openUniversityList()
        }
    }


}