package com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.domain.repository

import com.github.astat1cc.sergeybalakintesttask.core.utils.NetworkResult
import com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.domain.entities.ProductDetails

interface DetailsScreenRepository {

    suspend fun getDetails(): NetworkResult<ProductDetails>
}