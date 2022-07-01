package com.github.astat1cc.sergeybalakintesttask.featuremainscreen.presentation.fragments.main_fragment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.domain.entities.main_page.BestSeller
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.domain.entities.main_page.HotSale
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.domain.usecases.GetCartUseCase
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.domain.usecases.GetMainPageUseCase
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.presentation.adapters.delegate_adapter.DelegateAdapterItem
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.presentation.adapters.delegate_adapter.adapters.CategoryItemTag
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.presentation.adapters.delegate_adapter.items.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*

class MainViewModel(
    private val getMainPageUseCase: GetMainPageUseCase,
    private val getCartUseCase: GetCartUseCase,
    private val dispatcherIo: CoroutineDispatcher = Dispatchers.IO,
    private val dispatcherDefault: CoroutineDispatcher = Dispatchers.Default
) : ViewModel() {

    private val _mainPageItems: MutableLiveData<List<DelegateAdapterItem>> = MutableLiveData()
    val mainPageItems: LiveData<List<DelegateAdapterItem>> = _mainPageItems

    private lateinit var uiItemsFlow: Flow<List<DelegateAdapterItem>>

    private val _cartSize = MutableLiveData<Int>()
    private val _selectedCategoryTag = MutableLiveData<CategoryItemTag>(CategoryItemTag.PHONE)
    private val _brands = MutableLiveData<List<String>>()
    private val _prices = MutableLiveData<List<String>>(listOf("$0 - $10000"))
    private val _sizes = MutableLiveData<List<String>>(listOf("4.5 to 5.5 inches"))

    val cartSize: LiveData<Int> = _cartSize //todo
    val selectedCategoryTag: LiveData<CategoryItemTag> = _selectedCategoryTag
    val brands: LiveData<List<String>> = _brands
    val prices: LiveData<List<String>> = _prices
    val sizes: LiveData<List<String>> = _sizes

    private var bestSeller: List<BestSeller> = emptyList()
    private var hotSale: List<HotSale> = emptyList()
    private var selectedBrand = ""
    private var previouslySelectedBrand = ""

    init {
        getMainPage()
        getCart()
        submitUiItemsList()
        collectItems()
    }

    private fun collectItems() {
        viewModelScope.launch {
            uiItemsFlow.collect {
                _mainPageItems.postValue(it)
            }
        }
    }

    private fun submitUiItemsList() {
        val selectCategorySectionDelegateItem = SectionDelegateItem(
            "Select Category",
            "view all"
        )
        val hotSalesSectionDelegateItem = SectionDelegateItem(
            "Hot sales",
            "see more"
        )
        val bestSellerSectionDelegateItem = SectionDelegateItem(
            "Best Seller",
            "see more"
        )
        val categoriesDelegateItem = CategoriesDelegateItem()
        val searchDelegateItem = SearchDelegateItem()
        uiItemsFlow = flow {
            while (true) {
                val hotSalesDelegateItem = HotSalesDelegateItem(hotSale)
                val bestSellerDelegateItem = BestSellerDelegateItem(bestSeller)
                emit(
                    listOf(
                        selectCategorySectionDelegateItem,
                        categoriesDelegateItem,
                        searchDelegateItem,
                        hotSalesSectionDelegateItem,
                        hotSalesDelegateItem,
                        bestSellerSectionDelegateItem,
                        bestSellerDelegateItem
                    )
                )
                delay(500L)
            }
        }
    }

    private fun getMainPage() {
        viewModelScope.launch(dispatcherIo) {
            val mainPage = getMainPageUseCase.execute()
            hotSale = mainPage.hotSale
            bestSeller = mainPage.bestSeller
            getFilterOptions()
        }
    }

    private fun getFilterOptions() {
        viewModelScope.launch(dispatcherDefault) {
            val bestSellerBrands = bestSeller.map {
                it.extractBrand()
            }
            val homeStoreBrands = hotSale.map {
                it.extractBrand()
            }
            val brands = (bestSellerBrands + homeStoreBrands).distinct()
            _brands.postValue(brands)
            selectedBrand = brands[0]
        }
    }

    private fun HotSale.extractBrand() =
        title.split(" ").first()

    private fun BestSeller.extractBrand() =
        title.split(" ").first()

    private fun getCart() {
        viewModelScope.launch(dispatcherIo) {
            val cart = getCartUseCase.execute()
            _cartSize.postValue(cart.itemsCount)
        }
    }

    fun changeCategory(tag: CategoryItemTag) {
        _selectedCategoryTag.postValue(tag)
    }

    fun setSelectedBrand(brand: String) {
        selectedBrand = brand
        _brands.value?.let { brands ->
            val selectedBrandIndex = brands.indexOf(selectedBrand)
            Collections.swap(brands, selectedBrandIndex, 0)
            _brands.postValue(brands)
        }
    }

    // saves selected items in case user cancel filter options after some changing
    fun saveCurrentSelectedItems() {
        previouslySelectedBrand = selectedBrand
    }

    // restores selected items with items saved before opening filter dialog
    fun restorePreviousSelections() {
        selectedBrand = previouslySelectedBrand
        setSelectedBrand(selectedBrand)
    }
}