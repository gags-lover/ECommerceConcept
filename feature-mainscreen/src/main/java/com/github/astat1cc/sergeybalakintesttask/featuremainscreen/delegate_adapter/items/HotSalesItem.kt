package com.github.astat1cc.sergeybalakintesttask.featuremainscreen.delegate_adapter.items

import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.delegate_adapter.DelegateAdapterItem
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.viewpager.HotSalesViewPagerItem

data class HotSalesItem(
    val hotSales: List<HotSalesViewPagerItem>
) : DelegateAdapterItem {

    override fun id(): Any = 1

    override fun content(): Any = 1
}