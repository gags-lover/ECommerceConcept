package com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.di

import com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.data.remote.DetailsScreenService
import com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.data.repository.DetailsScreenRepositoryImpl
import com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.domain.repository.DetailsScreenRepository
import com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.domain.usecases.GetProductDetailsUseCase
import com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.presentation.fragments.details.viewmodel.DetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val detailsScreenModule = module {
    single {
        provideDetailsScreenService(retrofit = get())
    }
    single<DetailsScreenRepository> {
        DetailsScreenRepositoryImpl(detailsScreenService = get(), detailsScreenDao = get())
    }
    factory {
        GetProductDetailsUseCase(get())
    }
    viewModel {
        DetailsViewModel(get())
    }
}

fun provideDetailsScreenService(retrofit: Retrofit): DetailsScreenService =
    retrofit.create(DetailsScreenService::class.java)