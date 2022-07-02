package com.github.astat1cc.sergeybalakintesttask.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.github.astat1cc.sergeybalakintesttask.R
import com.github.astat1cc.sergeybalakintesttask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
//        val navController = navHostFragment.navController
//
//        navController.addOnDestinationChangedListener { _, destination, _ ->
//            binding.bottomNavBar.visibility = if (destination.id == R.id.mainFragment) {
//                View.VISIBLE
//            } else {
//                View.GONE
//            }
//        }
//
//        binding.bottomNavBar.setupWithNavController(navHostFragment.navController)
    }
}