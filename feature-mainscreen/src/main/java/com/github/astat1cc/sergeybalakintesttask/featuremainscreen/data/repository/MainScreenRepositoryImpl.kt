package com.github.astat1cc.sergeybalakintesttask.featuremainscreen.data.repository

import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.data.remote.MainScreenService
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.domain.entities.cart.Cart
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.domain.entities.main_page.MainPage
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.domain.repository.MainScreenRepository

class MainScreenRepositoryImpl(
    private val mainScreenService: MainScreenService
) : MainScreenRepository {

    override suspend fun getMainPage(): MainPage {
        val mainPageDto = mainScreenService.getMainDataAsync()
        return mainPageDto.mapToDomain()
    }

    override suspend fun getCart(): Cart {
        val cartDto = mainScreenService.getCartDataAsync()
        return cartDto.mapToDomain()
    }
}