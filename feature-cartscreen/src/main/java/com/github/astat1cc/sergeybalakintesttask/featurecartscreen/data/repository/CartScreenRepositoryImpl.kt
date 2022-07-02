package com.github.astat1cc.sergeybalakintesttask.featurecartscreen.data.repository

import com.github.astat1cc.sergeybalakintesttask.core.utils.NetworkResult
import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.data.remote.CartScreenService
import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.domain.entities.Cart
import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.domain.repository.CartScreenRepository
import java.lang.Exception

class CartScreenRepositoryImpl(private val cartScreenService: CartScreenService) :
    CartScreenRepository {

    override suspend fun getCart(): NetworkResult<Cart> {
        return try {
            val cart = cartScreenService.getCart().mapToDomain()
            NetworkResult.Success(cart)
        } catch (e: Exception) {
            NetworkResult.Error(e.message)
        }
    }
}