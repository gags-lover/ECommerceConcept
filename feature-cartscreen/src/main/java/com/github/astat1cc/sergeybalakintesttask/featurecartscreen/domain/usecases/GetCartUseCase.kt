package com.github.astat1cc.sergeybalakintesttask.featurecartscreen.domain.usecases

import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.domain.repository.CartScreenRepository

class GetCartUseCase(private val repository: CartScreenRepository) {

    suspend fun execute() = repository.getCart()
}