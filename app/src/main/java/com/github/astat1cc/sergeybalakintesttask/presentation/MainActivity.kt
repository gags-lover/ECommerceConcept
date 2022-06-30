package com.github.astat1cc.sergeybalakintesttask.presentation

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.github.astat1cc.sergeybalakintesttask.R
import com.github.astat1cc.sergeybalakintesttask.databinding.ActivityMainBinding
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.presentation.fragments.main_fragment.MainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { controller, destination, bundle ->
            binding.bottomNavBar.visibility = if (destination.id == R.id.mainFragment) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }

        binding.bottomNavBar.setupWithNavController(navHostFragment.navController)
    }
}