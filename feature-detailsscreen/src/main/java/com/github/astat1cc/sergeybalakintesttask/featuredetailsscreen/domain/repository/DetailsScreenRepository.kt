package com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.domain.repository

import com.github.astat1cc.sergeybalakintesttask.core.utils.FetchResult
import com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.domain.entities.ProductDetails

interface DetailsScreenRepository {

    suspend fun getDetails(): FetchResult<ProductDetails>
}