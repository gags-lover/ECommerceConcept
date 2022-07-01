package com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.domain.entities

data class ProductDetails(
    val cpu: String,
    val camera: String,
    val capacity: List<String>,
    val color: List<String>,
    val id: String,
    val images: List<String>,
    val isFavorites: Boolean,
    val price: Int,
    val rating: Double,
    val sd: String,
    val ram: String,
    val title: String
)