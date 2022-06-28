package com.github.astat1cc.sergeybalakintesttask.delegate_adapter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.github.astat1cc.sergeybalakintesttask.databinding.DelegateItemHotSalesViewpagerBinding
import com.github.astat1cc.sergeybalakintesttask.delegate_adapter.DelegateAdapter
import com.github.astat1cc.sergeybalakintesttask.delegate_adapter.items.HotSalesItem
import com.github.astat1cc.sergeybalakintesttask.delegate_adapter.items.SearchItem
import com.github.astat1cc.sergeybalakintesttask.viewpager.HotSalesViewPagerAdapter

class HotSalesAdapter :
    DelegateAdapter<HotSalesItem, HotSalesAdapter.HotSalesViewHolder>(HotSalesItem::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DelegateItemHotSalesViewpagerBinding.inflate(inflater, parent, false)
        return HotSalesViewHolder(binding)
    }

    override fun bindViewHolder(model: HotSalesItem, viewHolder: HotSalesViewHolder) {
        val viewPagerAdapter = HotSalesViewPagerAdapter(hotSales = model.hotSales)
        viewHolder.binding.hotSalesViewPager.adapter = viewPagerAdapter
    }

    inner class HotSalesViewHolder(
        val binding: DelegateItemHotSalesViewpagerBinding
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

