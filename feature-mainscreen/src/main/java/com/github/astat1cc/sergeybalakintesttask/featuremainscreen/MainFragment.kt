package com.github.astat1cc.sergeybalakintesttask.featuremainscreen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.databinding.FragmentMainBinding
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.delegate_adapter.CompositeAdapter
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.delegate_adapter.adapters.*
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.delegate_adapter.items.*
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.delegate_adapter.recycler.BestSellerRecyclerViewItem
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.viewpager.HotSalesViewPagerItem

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val categoryItemClickListener: (CategoryItemTag) -> Unit = { item ->
        categoriesAdapter.setSelectedItem(item)
//        when (item) {
//            CategoryItemTag.BOOKS -> Log.e("tag", "books")
//            CategoryItemTag.COMPUTER -> Log.e("tag", "computer")
//            CategoryItemTag.PHONE -> Log.e("tag", "phone")
//            CategoryItemTag.HEALTH -> Log.e("tag", "health")
//            CategoryItemTag.UNKNOWN -> Log.e("tag", "unknown")
//        }
    }

    private val categoriesAdapter = CategoriesAdapter(categoryItemClickListener)

    private val compositeAdapter by lazy {
        CompositeAdapter.Builder()
            .add(SectionAdapter())
            .add(categoriesAdapter)
            .add(SearchAdapter())
            .add(HotSalesAdapter())
            .add(BestSellerAdapter())
            .build()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val selectCategorySectionItem = SectionItem("Select Category", "view all")
        val categoriesItem = CategoriesItem()
        val searchItem = SearchItem()
        val hotSalesSectionItem = SectionItem("Hot sales", "see more")
        val hotSalesItem = HotSalesItem(
            listOf(
                HotSalesViewPagerItem(
                    1,
                    true,
                    "Iphone 12",
                    "subtitle",
                    "https://img.ibxk.com.br/2020/09/23/23104013057475.jpg?w=1120&h=420&mode=crop&scale=both",
                    true
                ),
                HotSalesViewPagerItem(
                    1,
                    true,
                    "Samsung Galaxy A71",
                    "subtitle",
                    "https://cdn-2.tstatic.net/kupang/foto/bank/images/pre-order-samsung-galaxy-a71-laris-manis-inilah-rekomendasi-ponsel-harga-rp-6-jutaan.jpg",
                    true
                ),
                HotSalesViewPagerItem(
                    1,
                    true,
                    "Xiaomi Mi 11 ultra",
                    "subtitle",
                    "https://static.digit.in/default/942998b8b4d3554a6259aeb1a0124384dbe0d4d5.jpeg",
                    true
                )
            )
        )
        val bestSellerSectionItem = SectionItem("Best Seller", "see more")
        val bestSellerItem = BestSellerItem(
            listOf(
                BestSellerRecyclerViewItem(
                    1,
                    false,
                    "Samsung Galaxy s20 Ultra",
                    1047,
                    1500,
                    "https://shop.gadgetufa.ru/images/upload/52534-smartfon-samsung-galaxy-s20-ultra-12-128-chernyj_1024.jpg"
                ),
                BestSellerRecyclerViewItem(
                    1,
                    true,
                    "Samsung Galaxy s20 Ultra",
                    1047,
                    1500,
                    "https://shop.gadgetufa.ru/images/upload/52534-smartfon-samsung-galaxy-s20-ultra-12-128-chernyj_1024.jpg"
                ),
                BestSellerRecyclerViewItem(
                    1,
                    false,
                    "Samsung Galaxy s20 Ultra",
                    1047,
                    1500,
                    "https://shop.gadgetufa.ru/images/upload/52534-smartfon-samsung-galaxy-s20-ultra-12-128-chernyj_1024.jpg"
                ),
                BestSellerRecyclerViewItem(
                    1,
                    true,
                    "Samsung Galaxy s20 Ultra",
                    1047,
                    1500,
                    "https://shop.gadgetufa.ru/images/upload/52534-smartfon-samsung-galaxy-s20-ultra-12-128-chernyj_1024.jpg"
                ),
                BestSellerRecyclerViewItem(
                    1,
                    false,
                    "Samsung Galaxy s20 Ultra",
                    1047,
                    1500,
                    "https://shop.gadgetufa.ru/images/upload/52534-smartfon-samsung-galaxy-s20-ultra-12-128-chernyj_1024.jpg"
                ),
                BestSellerRecyclerViewItem(
                    1,
                    true,
                    "Samsung Galaxy s20 Ultra",
                    1047,
                    1500,
                    "https://shop.gadgetufa.ru/images/upload/52534-smartfon-samsung-galaxy-s20-ultra-12-128-chernyj_1024.jpg"
                )
            )
        )

        val list =
            listOf(
                selectCategorySectionItem,
                categoriesItem,
                searchItem,
                hotSalesSectionItem,
                hotSalesItem,
                bestSellerSectionItem,
                bestSellerItem
            )

        binding.mainRecyclerView.adapter = compositeAdapter
        binding.mainRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        compositeAdapter.submitList(list)

        categoriesAdapter.setSelectedItem(CategoryItemTag.PHONE)
    }
}