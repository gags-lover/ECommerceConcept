package com.github.astat1cc.sergeybalakintesttask.featurecartscreen.domain.entities

data class Cart(
    val basket: List<Basket>,
    val delivery: String,
    val id: String,
    val total: Int
)