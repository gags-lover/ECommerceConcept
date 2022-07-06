package com.github.astat1cc.sergeybalakintesttask.featuremap.di

import com.github.astat1cc.sergeybalakintesttask.featuremap.presentation.fragments.map.viewmodel.MapViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mapModule = module {
    viewModel {
        MapViewModel()
    }
}