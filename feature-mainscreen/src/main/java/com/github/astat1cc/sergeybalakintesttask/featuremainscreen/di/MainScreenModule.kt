package com.github.astat1cc.sergeybalakintesttask.featuremainscreen.di

import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.data.remote.MainScreenService
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.data.repository.MainScreenRepositoryImpl
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.domain.repository.MainScreenRepository
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.domain.usecases.GetCartUseCase
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.domain.usecases.GetMainPageUseCase
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.presentation.fragments.main_fragment.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val mainScreenModule = module {
    single {
        provideMainScreenService(retrofit = get())
    }
    single<MainScreenRepository> {
        MainScreenRepositoryImpl(mainScreenService = get(), mainScreenDao = get())
    }
    factory {
        GetMainPageUseCase(get())
    }
    factory {
        GetCartUseCase(get())
    }
    viewModel {
        MainViewModel(get(), get())
    }
}

fun provideMainScreenService(retrofit: Retrofit): MainScreenService =
    retrofit.create(MainScreenService::class.java)