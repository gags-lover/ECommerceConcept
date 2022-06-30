package com.github.astat1cc.sergeybalakintesttask.featuremainscreen.data.remote.models.cart

import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.domain.entities.cart.Cart

data class CartDto(
    val id: String,
    val basket: List<Basket>
) {

    fun mapToDomain() = Cart(id = id, itemsCount = basket.size)
}