package com.github.astat1cc.sergeybalakintesttask.delegate_adapter.items

import com.github.astat1cc.sergeybalakintesttask.delegate_adapter.DelegateAdapterItem
import com.github.astat1cc.sergeybalakintesttask.delegate_adapter.recycler.BestSellerRecyclerViewItem
import com.github.astat1cc.sergeybalakintesttask.viewpager.HotSalesViewPagerItem

data class BestSellerItem(
    val bestSellers: List<BestSellerRecyclerViewItem>
) : DelegateAdapterItem {

    override fun id(): Any = 1

    override fun content(): Any = 1
}