package com.github.astat1cc.sergeybalakintesttask.featurecartscreen.domain.entities

data class Basket(
    val id: Int,
    val images: String,
    val price: Int,
    val title: String,
    val count: Int? = null
)