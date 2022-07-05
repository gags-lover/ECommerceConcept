package com.github.astat1cc.sergeybalakintesttask.featuremainscreen.domain.repository

import com.github.astat1cc.sergeybalakintesttask.core.utils.FetchResult
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.domain.entities.cart.Cart
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.domain.entities.main_page.MainPage

interface MainScreenRepository {

    suspend fun getMainPage(): FetchResult<MainPage>

    suspend fun getCart(): FetchResult<Cart>
}