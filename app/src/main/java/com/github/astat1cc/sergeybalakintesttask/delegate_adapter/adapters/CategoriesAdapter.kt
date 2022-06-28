package com.github.astat1cc.sergeybalakintesttask.delegate_adapter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.astat1cc.sergeybalakintesttask.databinding.DelegateItemCategoriesBinding
import com.github.astat1cc.sergeybalakintesttask.delegate_adapter.DelegateAdapter
import com.github.astat1cc.sergeybalakintesttask.delegate_adapter.items.CategoriesItem
import com.github.astat1cc.sergeybalakintesttask.delegate_adapter.items.SectionItem

class CategoriesAdapter :
    DelegateAdapter<CategoriesItem, CategoriesAdapter.CategoriesViewHolder>(CategoriesItem::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DelegateItemCategoriesBinding.inflate(inflater, parent, false)
        return CategoriesViewHolder(binding)
    }

    override fun bindViewHolder(model: CategoriesItem, viewHolder: CategoriesViewHolder) {}

    inner class CategoriesViewHolder(
        val binding: DelegateItemCategoriesBinding
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