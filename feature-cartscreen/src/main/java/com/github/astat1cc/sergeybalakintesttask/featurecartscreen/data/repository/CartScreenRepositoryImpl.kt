package com.github.astat1cc.sergeybalakintesttask.featurecartscreen.data.repository

import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.data.remote.CartScreenService
import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.domain.entities.Cart
import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.domain.repository.CartScreenRepository

class CartScreenRepositoryImpl(private val cartScreenService: CartScreenService) : CartScreenRepository {

    override suspend fun getCart(): Cart {
        val cartDto = cartScreenService.getCart()
        return cartDto.mapToDomain()
    }
}