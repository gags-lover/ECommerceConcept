package com.github.astat1cc.sergeybalakintesttask.featuremainscreen.presentation.adapters.delegate_adapter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.databinding.DelegateItemHotSalesViewpagerBinding
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.presentation.adapters.delegate_adapter.DelegateAdapter
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.presentation.adapters.delegate_adapter.items.HotSalesItem
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.presentation.adapters.viewpager.HotSalesViewPagerAdapter

class HotSalesAdapter :
    DelegateAdapter<HotSalesItem, HotSalesAdapter.HotSalesViewHolder>(HotSalesItem::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DelegateItemHotSalesViewpagerBinding.inflate(inflater, parent, false)
        return HotSalesViewHolder(binding)
    }

    override fun bindViewHolder(model: HotSalesItem, viewHolder: HotSalesViewHolder) {
        with(viewHolder) {
            progressBar.visibility = if (model.hotSales.isEmpty()) {
                View.VISIBLE
                return
            } else {
                View.GONE
            }
            viewPager.adapter = HotSalesViewPagerAdapter(hotSales = model.hotSales)
        }
    }

    inner class HotSalesViewHolder(
        val binding: DelegateItemHotSalesViewpagerBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        val progressBar = binding.hotSalesProgressBar
        val viewPager = binding.hotSalesViewPager
    }
}

