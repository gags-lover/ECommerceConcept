package com.github.astat1cc.sergeybalakintesttask.featuremainscreen.domain.repository

import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.domain.entities.cart.Cart
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.domain.entities.main_page.MainPage

interface MainScreenRepository {

    suspend fun getMainPage(): MainPage

    suspend fun getCart(): Cart
}