package com.github.astat1cc.sergeybalakintesttask.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.github.astat1cc.sergeybalakintesttask.R
import com.github.astat1cc.sergeybalakintesttask.databinding.ActivityMainBinding
import com.github.astat1cc.sergeybalakintesttask.navigation.AppRoutes
import com.github.astat1cc.sergeybalakintesttask.notification.FIREBASE_ACTION_OPEN_CART
import com.github.astat1cc.sergeybalakintesttask.notification.FIREBASE_NOTIFICATION_ACTION_KEY

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkIntentAction(intent)
    }

    private fun checkIntentAction(intent: Intent?) {
        intent?.let {
            val action = it.extras?.get(FIREBASE_NOTIFICATION_ACTION_KEY)
            when (action) {
                FIREBASE_ACTION_OPEN_CART -> {
                    val navHostFragment =
                        supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
                    navHostFragment.findNavController().navigate(AppRoutes.CartScreen.Entry)
                }
                else -> {
                    Log.e("tag", "Unknown action")
                }
            }
        }
    }
}