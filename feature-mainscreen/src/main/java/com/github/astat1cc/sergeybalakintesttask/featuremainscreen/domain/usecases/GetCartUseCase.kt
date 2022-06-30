package com.github.astat1cc.sergeybalakintesttask.featuremainscreen.domain.usecases

import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.domain.repository.MainScreenRepository

class GetCartUseCase(private val repository: MainScreenRepository) {

    suspend fun execute() = repository.getCart()
}