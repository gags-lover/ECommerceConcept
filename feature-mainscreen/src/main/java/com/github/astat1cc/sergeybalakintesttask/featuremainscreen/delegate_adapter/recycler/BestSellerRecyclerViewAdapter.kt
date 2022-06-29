package com.github.astat1cc.sergeybalakintesttask.featuremainscreen.delegate_adapter.recycler

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.R
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.databinding.ItemBestSellerBinding

class BestSellerRecyclerViewAdapter(
    private val bestSellers: List<BestSellerRecyclerViewItem>
) : RecyclerView.Adapter<BestSellerRecyclerViewAdapter.BestSellerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBestSellerBinding.inflate(inflater, parent, false)
        return BestSellerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BestSellerViewHolder, position: Int) {
        val item = bestSellers[position]
        with(holder.binding) {
            Glide.with(bestSellerImageView).load(item.picture).into(bestSellerImageView)
            titleBestSellerTextView.text = item.title
            favouriteButton.setImageResource(
                if (item.is_favorites) {
                    R.drawable.ic_fab_favorites
                } else {
                    R.drawable.ic_fab_favourites_border
                }
            )
            priceWithDiscountTextView.text = item.discount_price.toPriceFormat()
            priceWithDiscountTextView.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            priceWithoutDiscountTextView.text = item.price_without_discount.toPriceFormat()
        }
    }

    override fun getItemCount(): Int = bestSellers.size

    inner class BestSellerViewHolder(val binding: ItemBestSellerBinding) :
        RecyclerView.ViewHolder(binding.root)
}

private fun Int.toPriceFormat(): String =
    "$%.${3}f".format(this / 1000.0)
