package com.github.astat1cc.sergeybalakintesttask.featuremainscreen.data.remote.models.main_page

import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.domain.entities.main_page.BestSeller

data class BestSellerDto(
    val discount_price: Int,
    val id: Int,
    val is_favorites: Boolean,
    val picture: String,
    val price_without_discount: Int,
    val title: String
) {

    fun mapToDomain() = BestSeller(
        discountPrice = discount_price,
        id = id,
        isFavorites = is_favorites,
        picture = picture,
        priceWithoutDiscount = price_without_discount,
        title = title
    )
}