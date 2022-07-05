package com.github.astat1cc.sergeybalakintesttask.featuremainscreen.data.remote.models.cart

import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.domain.entities.cart.Cart

data class CartNetworkDto(
    val basket: List<BasketNetworkDto>
) {

    fun mapToDomain() = Cart(itemsCount = basket.size)
}