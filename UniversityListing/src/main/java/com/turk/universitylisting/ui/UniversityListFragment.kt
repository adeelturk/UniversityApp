package com.turk.universitylisting.ui

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.turk.common.base.BaseFragment
import com.turk.common.base.BaseViewModel
import com.turk.common.base.GeneralAdapter
import com.turk.common.base.ViewState
import com.turk.dtos.model.University
import com.turk.universitylisting.BR
import com.turk.universitylisting.R
import com.turk.universitylisting.UniversityViewmodel
import com.turk.universitylisting.databinding.UniversityListFragmentBinding
import com.turk.universitylisting.nav.UniversityListNav
import com.turk.universitylisting.state.UniversityState
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UniversityListFragment : BaseFragment<UniversityListFragmentBinding,UniversityState>() {

    @Inject
    lateinit var universityListNav: UniversityListNav

    private val universityViewModel: UniversityViewmodel by viewModels()
    private val adapter = GeneralAdapter(BR.universityData, R.layout.university_item, University.DIFF_CALLBACK)

    override fun layoutResourceId(): Int= R.layout.university_list_fragment

    override fun getViewModel() =universityViewModel

    override fun handleViewState(state: ViewState) {

        when(val state= state as UniversityState){
            UniversityState.DEFAULT ->{}
            UniversityState.Loading -> {
                binding.swipeRefresh.isRefreshing=true
            }
            is UniversityState.SUCCESS -> {
                binding.swipeRefresh.isRefreshing=false
                adapter.submitList(state.data)
            }
        }
    }

    override fun initialize(savedInstanceState: Bundle?) {

        binding.adapter=adapter
        universityViewModel.fetchUniversities()
        binding.swipeRefresh.setOnRefreshListener {
            universityViewModel.fetchUniversities()
        }

        adapter.clickListener={ data,view->

            universityListNav.moveToUniversityDetail(data)
        }
    }


}