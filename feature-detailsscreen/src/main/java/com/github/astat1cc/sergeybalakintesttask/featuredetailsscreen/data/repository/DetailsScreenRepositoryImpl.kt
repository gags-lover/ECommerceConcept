package com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.data.repository

import com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.data.remote.DetailsScreenService
import com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.domain.entities.ProductDetails
import com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.domain.repository.DetailsScreenRepository

class DetailsScreenRepositoryImpl(private val detailsScreenService: DetailsScreenService) : DetailsScreenRepository {

    override suspend fun getDetails(): ProductDetails {
        val productDetailsDto = detailsScreenService.getDetails()
        return productDetailsDto.mapToDomain()
    }
}