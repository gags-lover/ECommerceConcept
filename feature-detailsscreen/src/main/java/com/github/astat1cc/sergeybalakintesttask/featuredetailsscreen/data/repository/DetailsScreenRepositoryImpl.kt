package com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.data.repository

import com.github.astat1cc.sergeybalakintesttask.core.utils.NetworkResult
import com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.data.remote.DetailsScreenService
import com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.domain.entities.ProductDetails
import com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.domain.repository.DetailsScreenRepository
import java.lang.Exception

class DetailsScreenRepositoryImpl(private val detailsScreenService: DetailsScreenService) :
    DetailsScreenRepository {

    override suspend fun getDetails(): NetworkResult<ProductDetails> {
        return try {
            val productDetails = detailsScreenService.getDetails().mapToDomain()
            NetworkResult.Success(productDetails)
        } catch (e: Exception) {
            NetworkResult.Error(e.message)
        }
    }
}