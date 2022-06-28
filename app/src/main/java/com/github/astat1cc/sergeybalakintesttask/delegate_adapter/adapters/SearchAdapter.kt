package com.github.astat1cc.sergeybalakintesttask.delegate_adapter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.astat1cc.sergeybalakintesttask.databinding.DelegateItemSearchBinding
import com.github.astat1cc.sergeybalakintesttask.delegate_adapter.DelegateAdapter
import com.github.astat1cc.sergeybalakintesttask.delegate_adapter.items.SearchItem

class SearchAdapter:
    DelegateAdapter<SearchItem, SearchAdapter.SearchViewHolder>(SearchItem::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DelegateItemSearchBinding.inflate(inflater, parent, false)
        return SearchViewHolder(binding)
    }

    override fun bindViewHolder(model: SearchItem, viewHolder: SearchViewHolder) {}

    inner class SearchViewHolder(
        val binding: DelegateItemSearchBinding
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

