package com.github.astat1cc.sergeybalakintesttask.featurecartscreen.presentation.fragments.cart_fragment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.domain.entities.Basket
import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.domain.entities.Cart
import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.domain.usecases.GetCartUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartViewModel(
    private val getCartUseCase: GetCartUseCase,
    private val dispatcherIo: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _cartItems = MutableLiveData<List<Basket>>()
    private val _total = MutableLiveData<Int>()
    private val _delivery = MutableLiveData<String>()

    val cartItems: LiveData<List<Basket>> = _cartItems
    val total: LiveData<Int> = _total
    val delivery: LiveData<String> = _delivery

    init {
        getCart()
    }

    private fun getCart() {
        viewModelScope.launch(dispatcherIo) {
            val cart = getCartUseCase.execute()
            _cartItems.postValue(cart.basket)
            _total.postValue(cart.total)
            _delivery.postValue(cart.delivery)
        }
    }
}