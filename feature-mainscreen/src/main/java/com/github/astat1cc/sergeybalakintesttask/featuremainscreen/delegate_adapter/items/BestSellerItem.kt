package com.github.astat1cc.sergeybalakintesttask.featuremainscreen.delegate_adapter.items

import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.delegate_adapter.DelegateAdapterItem
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.delegate_adapter.recycler.BestSellerRecyclerViewItem

data class BestSellerItem(
    val bestSellers: List<BestSellerRecyclerViewItem>
) : DelegateAdapterItem {

    override fun id(): Any = 1

    override fun content(): Any = 1
}