package com.github.astat1cc.sergeybalakintesttask.delegate_adapter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.astat1cc.sergeybalakintesttask.databinding.DelegateItemSectionBinding
import com.github.astat1cc.sergeybalakintesttask.delegate_adapter.DelegateAdapter
import com.github.astat1cc.sergeybalakintesttask.delegate_adapter.items.SectionItem

class SectionAdapter :
    DelegateAdapter<SectionItem, SectionAdapter.SectionViewHolder>(SectionItem::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DelegateItemSectionBinding.inflate(inflater, parent, false)
        return SectionViewHolder(binding)
    }

    override fun bindViewHolder(model: SectionItem, viewHolder: SectionViewHolder) {
        viewHolder.bind(model)
    }

    inner class SectionViewHolder(
        val binding: DelegateItemSectionBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SectionItem) {
            with(binding) {
                sectionTitleTextView.text = item.sectionTitle
                moreTextView.text = item.moreButtonText
            }
        }

//        fun bindDepartureTime(departureTime: String) {
//            //..
//        }
//
//        fun bindArrivalTime(arrivalTime: String) {
//            //..
//        }
    }
}