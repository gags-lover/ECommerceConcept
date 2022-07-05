package com.github.astat1cc.sergeybalakintesttask.featurecartscreen.data.repository

import com.github.astat1cc.sergeybalakintesttask.core.utils.FetchResult
import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.data.local.dao.CartScreenDao
import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.data.local.models.CartLocalDto
import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.data.remote.CartScreenService
import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.domain.entities.Cart
import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.domain.repository.CartScreenRepository
import java.lang.Exception

class CartScreenRepositoryImpl(
    private val cartScreenService: CartScreenService,
    private val cartScreenDao: CartScreenDao
) : CartScreenRepository {

    override suspend fun getCart(): FetchResult<Cart> =
        try {
            getCartFromDatabase()
        } catch (e: NullPointerException) {
            val cartNetworkResult = getCartFromNetwork()
            if (cartNetworkResult is FetchResult.Success) {
                saveCartInDatabase(cartNetworkResult.data)
            }
            cartNetworkResult
        }

    private fun getCartFromDatabase(): FetchResult<Cart> =
        FetchResult.Success(cartScreenDao.getCart().mapToDomain())

    private suspend fun getCartFromNetwork(): FetchResult<Cart> =
        try {
            val cart = cartScreenService.getCart().mapToDomain()
            FetchResult.Success(cart)
        } catch (e: Exception) {
            FetchResult.Error(e.message)
        }

    private fun saveCartInDatabase(details: Cart) {
        cartScreenDao.saveCart(CartLocalDto.fromDomain(details))
    }
}