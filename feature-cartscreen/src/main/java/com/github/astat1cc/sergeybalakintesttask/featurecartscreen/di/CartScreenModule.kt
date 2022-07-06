package com.github.astat1cc.sergeybalakintesttask.featurecartscreen.di

import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.data.remote.CartScreenService
import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.data.repository.CartScreenRepositoryImpl
import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.domain.repository.CartScreenRepository
import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.domain.usecases.GetCartUseCase
import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.presentation.fragments.cart_fragment.viewmodel.CartViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val cartScreenModule = module {
    single {
        provideCartScreenService(retrofit = get())
    }
    single<CartScreenRepository> {
        CartScreenRepositoryImpl(cartScreenService = get(), cartScreenDao = get())
    }
    factory {
        GetCartUseCase(get())
    }
    viewModel {
        CartViewModel(get())
    }
}

fun provideCartScreenService(retrofit: Retrofit): CartScreenService =
    retrofit.create(CartScreenService::class.java)