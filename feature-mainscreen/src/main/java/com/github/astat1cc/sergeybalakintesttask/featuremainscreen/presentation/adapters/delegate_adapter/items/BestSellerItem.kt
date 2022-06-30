package com.github.astat1cc.sergeybalakintesttask.featuremainscreen.presentation.adapters.delegate_adapter.items

import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.domain.entities.main_page.BestSeller
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.presentation.adapters.delegate_adapter.DelegateAdapterItem

data class BestSellerItem(
    val bestSellers: List<BestSeller>
) : DelegateAdapterItem {

    override fun id(): Any = hashCode()

    override fun content(): Any = 1
}