package com.github.astat1cc.sergeybalakintesttask.featuremainscreen.presentation.adapters.delegate_adapter.items

import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.domain.entities.main_page.HotSale
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.presentation.adapters.delegate_adapter.DelegateAdapterItem

data class HotSalesDelegateItem(
    val hotSales: List<HotSale>
) : DelegateAdapterItem {

    override fun id(): Any = hashCode()

    override fun content(): Any = 1
}