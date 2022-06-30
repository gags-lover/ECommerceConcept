package com.github.astat1cc.sergeybalakintesttask.featuremainscreen.presentation.adapters.delegate_adapter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.databinding.DelegateItemBestSellerRecyclerviewBinding
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.presentation.adapters.delegate_adapter.DelegateAdapter
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.presentation.adapters.delegate_adapter.items.BestSellerItem
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.presentation.fragments.main_fragment.recyclerview.BestSellerRecyclerViewAdapter

class BestSellerAdapter :
    DelegateAdapter<BestSellerItem, BestSellerAdapter.BestSellerViewHolder>(BestSellerItem::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DelegateItemBestSellerRecyclerviewBinding.inflate(inflater, parent, false)
        return BestSellerViewHolder(binding)
    }

    override fun bindViewHolder(model: BestSellerItem, viewHolder: BestSellerViewHolder) {
        with(viewHolder) {
            progressBar.visibility = if (model.bestSellers.isEmpty()) {
                View.VISIBLE
                return
            } else {
                View.GONE
            }
            recyclerView.adapter = BestSellerRecyclerViewAdapter(bestSellers = model.bestSellers)
        }
    }

    inner class BestSellerViewHolder(
        val binding: DelegateItemBestSellerRecyclerviewBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        val progressBar = binding.bestSellerProgressBar
        val recyclerView = binding.bestSellerRecyclerView
    }
}

