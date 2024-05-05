package com.turk.universityapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.turk.dtos.model.University
import com.turk.universityapp.nav.MainRouteHandler
import com.turk.universityapp.nav.Navigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(),MainRouteHandler {
    private lateinit var navController: NavController

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController =
            (supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment).navController
        navigator.setupNavController(this)

    }

    override fun moveToUniversityDetail(selectedUniversity: University) {
        val bundle = Bundle()
        bundle.putParcelable("selectedUniv",selectedUniversity)
        navController.navigate(R.id.action_universitylistFragment_to_universityDetailFragment,bundle)

    }

    override fun openUniversityList() {
        navController.popBackStack()
    }
}