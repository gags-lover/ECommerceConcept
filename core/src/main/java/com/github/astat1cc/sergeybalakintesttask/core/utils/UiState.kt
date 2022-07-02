package com.github.astat1cc.sergeybalakintesttask.core.utils

sealed class UiState {

    object Success : UiState()
    object Error : UiState()
    object Loading : UiState()
}