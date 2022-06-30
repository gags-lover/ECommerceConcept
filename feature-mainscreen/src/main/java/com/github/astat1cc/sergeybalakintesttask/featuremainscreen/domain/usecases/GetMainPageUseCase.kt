package com.github.astat1cc.sergeybalakintesttask.featuremainscreen.domain.usecases

import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.domain.repository.MainScreenRepository

class GetMainPageUseCase(private val repository: MainScreenRepository) {

    suspend fun execute() = repository.getMainPage()
}