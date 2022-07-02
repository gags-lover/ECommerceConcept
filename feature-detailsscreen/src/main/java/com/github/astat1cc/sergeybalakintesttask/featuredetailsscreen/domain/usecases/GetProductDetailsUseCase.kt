package com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.domain.usecases

import com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.domain.repository.DetailsScreenRepository

class GetProductDetailsUseCase(private val repository: DetailsScreenRepository) {

    suspend fun execute() = repository.getDetails()
}