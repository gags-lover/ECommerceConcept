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

    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment

        checkIntentForNotificationAction()
    }

    private fun checkIntentForNotificationAction() {
        intent?.let {
            val action = it.extras?.get(FIREBASE_NOTIFICATION_ACTION_KEY)
            if (action == FIREBASE_ACTION_OPEN_CART) {
                navHostFragment.findNavController().navigate(AppRoutes.CartScreen.Entry)
            }
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        navHostFragment.findNavController().handleDeepLink(intent)
    }
}