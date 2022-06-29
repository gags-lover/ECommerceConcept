package com.github.astat1cc.sergeybalakintesttask.featuremainscreen.delegate_adapter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.databinding.DelegateItemBestSellerRecyclerviewBinding
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.delegate_adapter.DelegateAdapter
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.delegate_adapter.items.BestSellerItem
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.delegate_adapter.recycler.BestSellerRecyclerViewAdapter

class BestSellerAdapter :
    DelegateAdapter<BestSellerItem, BestSellerAdapter.BestSellerViewHolder>(BestSellerItem::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DelegateItemBestSellerRecyclerviewBinding.inflate(inflater, parent, false)
        return BestSellerViewHolder(binding)
    }

    override fun bindViewHolder(model: BestSellerItem, viewHolder: BestSellerViewHolder) {
        val recyclerViewAdapter = BestSellerRecyclerViewAdapter(bestSellers = model.bestSellers)
        viewHolder.binding.bestSellerRecyclerView.adapter = recyclerViewAdapter
    }

    inner class BestSellerViewHolder(
        val binding: DelegateItemBestSellerRecyclerviewBinding
    ) : RecyclerView.ViewHolder(binding.root) {

//        fun bind(item: CategoriesItem) {
//
//        }

//        fun bindDepartureTime(departureTime: String) {
//            //..
//        }
//
//        fun bindArrivalTime(arrivalTime: String) {
//            //..
//        }
    }
}

