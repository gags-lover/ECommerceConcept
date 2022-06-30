package com.github.astat1cc.sergeybalakintesttask.presentation

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.github.astat1cc.sergeybalakintesttask.R
import com.github.astat1cc.sergeybalakintesttask.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            if (view.isVisible) {
//                val navOptions =
//                    NavOptions.Builder().setPopUpTo(R.id.mainFragment, true, true).build()
//                findNavController().navigate(
//                    R.id.mainFragment,
//                    savedInstanceState,
//                    navOptions
//                )
                findNavController().navigate(R.id.action_splashFragment_to_mainFragment2)
            }
        }, 1500)
    }
}