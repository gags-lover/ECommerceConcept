package com.github.astat1cc.sergeybalakintesttask.presentation

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.github.astat1cc.sergeybalakintesttask.databinding.FragmentSplashBinding
import com.github.astat1cc.sergeybalakintesttask.navigation.R.id.action_splash_to_mainscreen

class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        Handler(Looper.getMainLooper()).postDelayed({
            view?.let {
                if (it.isVisible) {
                    findNavController().navigate(action_splash_to_mainscreen)
                }
            }
        }, 1500)
    }
}