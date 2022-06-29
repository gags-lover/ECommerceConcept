package com.github.astat1cc.sergeybalakintesttask.featuremainscreen.delegate_adapter.recycler

data class BestSellerRecyclerViewItem(
    val id: Int,
    val is_favorites: Boolean,
    val title: String,
    val price_without_discount: Int,
    val discount_price: Int,
    val picture: String
)