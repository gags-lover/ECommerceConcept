package com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.data.repository

import com.github.astat1cc.sergeybalakintesttask.core.utils.FetchResult
import com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.data.local.dao.DetailsScreenDao
import com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.data.local.models.ProductDetailsLocalDto
import com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.data.remote.DetailsScreenService
import com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.domain.entities.ProductDetails
import com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.domain.repository.DetailsScreenRepository
import java.lang.Exception

class DetailsScreenRepositoryImpl(
    private val detailsScreenService: DetailsScreenService,
    private val detailsScreenDao: DetailsScreenDao
) : DetailsScreenRepository {

    override suspend fun getDetails(): FetchResult<ProductDetails> =
        try {
            getProductDetailsFromDatabase()
        } catch (e: NullPointerException) {
            val productDetailsNetworkResult = getProductDetailsFromNetwork()
            if (productDetailsNetworkResult is FetchResult.Success) {
                saveProductDetailsInDatabase(productDetailsNetworkResult.data)
            }
            productDetailsNetworkResult
        }

    private fun getProductDetailsFromDatabase(): FetchResult<ProductDetails> =
        FetchResult.Success(detailsScreenDao.getProductDetails().mapToDomain())

    private suspend fun getProductDetailsFromNetwork(): FetchResult<ProductDetails> =
        try {
            val productDetails = detailsScreenService.getDetails().mapToDomain()
            FetchResult.Success(productDetails)
        } catch (e: Exception) {
            FetchResult.Error(e.message)
        }

    private fun saveProductDetailsInDatabase(details: ProductDetails) {
        detailsScreenDao.saveProductDetails(ProductDetailsLocalDto.fromDomain(details))
    }
}