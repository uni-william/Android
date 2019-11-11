package com.example.vender

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.example.vender.features.UserSessionViewModel
import com.example.vender.utils.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var finalHost: NavHostFragment
    private val userModel: UserSessionViewModel by viewModels()

    private lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.nav_main)


        userModel.authenticationState.observe(this, Observer { authenticationState ->
            when (authenticationState) {
                UserSessionViewModel.AuthenticationState.AUTHENTICATED -> {
                    supportFragmentManager.beginTransaction().remove((finalHost)).commit()
                    mainFlow()
                }
                UserSessionViewModel.AuthenticationState.UNAUTHENTICATED -> {
                    loginFlow()
                } else -> bottomNavigationView.visibility = View.GONE
            }
        })

    }

    private fun mainFlow() {
        bottomNavigationView.visibility = View.VISIBLE

        val navGraphIds = listOf(R.navigation.home_graph, R.navigation.publish_graph, R.navigation.settings_graph)

        // Setup the bottom navigation view with a list of navigation graphs
       bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.host,
            intent = intent
        )
    }

    private fun loginFlow() {
        bottomNavigationView.visibility = View.GONE
        if(!::finalHost.isInitialized) {
            finalHost = NavHostFragment.create(R.navigation.auth_graph)
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.host, finalHost)
            .setPrimaryNavigationFragment(finalHost) // this is the equivalent to app:defaultNavHost="true"
            .commit()
    }
}
