package com.github.astat1cc.sergeybalakintesttask.featuremainscreen.data.remote.models.main_page

import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.domain.entities.main_page.MainPage

data class MainPageDto(
    val best_seller: List<BestSellerDto>,
    val home_store: List<HomeStoreDto>
) {

    fun mapToDomain() = MainPage(
        bestSeller = best_seller.map { it.mapToDomain() },
        hotSale = home_store.map { it.mapToDomain() })
}