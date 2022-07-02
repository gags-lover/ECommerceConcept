package com.github.astat1cc.sergeybalakintesttask.featuremainscreen.data.repository

import com.github.astat1cc.sergeybalakintesttask.core.utils.NetworkResult
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.data.remote.MainScreenService
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.domain.entities.cart.Cart
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.domain.entities.main_page.MainPage
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.domain.repository.MainScreenRepository
import java.lang.Exception

class MainScreenRepositoryImpl(
    private val mainScreenService: MainScreenService
) : MainScreenRepository {

    override suspend fun getMainPage(): NetworkResult<MainPage> {
        return try {
            val mainPage = mainScreenService.getMainDataAsync().mapToDomain()
            NetworkResult.Success(mainPage)
        } catch (e: Exception) {
            NetworkResult.Error(e.message)
        }
    }

    override suspend fun getCart(): NetworkResult<Cart> {
        return try {
            val cartDto = mainScreenService.getCartDataAsync().mapToDomain()
            NetworkResult.Success(cartDto)
        } catch (e: Exception) {
            NetworkResult.Error(e.message)
        }
    }
}