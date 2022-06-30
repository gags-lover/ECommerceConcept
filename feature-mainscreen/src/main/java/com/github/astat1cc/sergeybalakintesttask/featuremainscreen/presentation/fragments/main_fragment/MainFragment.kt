package com.github.astat1cc.sergeybalakintesttask.featuremainscreen.presentation.fragments.main_fragment

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.R
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.databinding.FragmentMainBinding
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.presentation.adapters.delegate_adapter.CompositeAdapter
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.presentation.adapters.delegate_adapter.adapters.*
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.presentation.fragments.main_fragment.utils.FilterCategory
import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.presentation.fragments.main_fragment.viewmodel.MainViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel by viewModel<MainViewModel>()

    private val categoryItemClickListener: (CategoryItemTag) -> Unit = { itemTag ->
        viewModel.changeCategory(itemTag)
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

    private var brandsFilterItems: List<String> = emptyList()
    private var pricesFilterItems: List<String> = emptyList()
    private var sizesFilterItems: List<String> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe()
        setupRecyclerView()

        binding.filterImageView.setOnClickListener {
            showFilter()
        }
    }

    private fun showFilter() {
        viewModel.saveCurrentSelectedItems()
        val filterDialog = createFilterBottomSheetDialog()
        filterDialog.show()
    }

    private val filterSpinnerOnItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(
            adapterView: AdapterView<*>?,
            v: View?,
            position: Int,
            id: Long
        ) {
            when (adapterView?.tag) {
                FilterCategory.BRAND -> brandSelected(brandsFilterItems[position])
                FilterCategory.PRICE -> {}
                FilterCategory.SIZE -> {}
            }
        }

        override fun onNothingSelected(p0: AdapterView<*>?) {}
    }

    private fun createFilterBottomSheetDialog(): BottomSheetDialog {
        val bottomSheetDialog = BottomSheetDialog(requireContext())
        with(bottomSheetDialog) {
            setContentView(R.layout.bottom_sheet_dialog_filter)
            findViewById<Spinner>(R.id.brandsSpinner)?.setFilterSpinner(FilterCategory.BRAND)
            findViewById<Spinner>(R.id.priceSpinner)?.setFilterSpinner(FilterCategory.PRICE)
            findViewById<Spinner>(R.id.sizeSpinner)?.setFilterSpinner(FilterCategory.SIZE)
            findViewById<TextView>(R.id.doneTextView)?.setOnClickListener { hide() }
            findViewById<ImageView>(R.id.closeImageView)?.setOnClickListener {
                viewModel.restorePreviousSelections()
                dismiss()
            }
        }
        return bottomSheetDialog
    }

    private fun Spinner.setFilterSpinner(category: FilterCategory) {
        val items = when (category) {
            FilterCategory.BRAND -> brandsFilterItems
            FilterCategory.PRICE -> pricesFilterItems
            FilterCategory.SIZE -> sizesFilterItems
        }
        adapter = createSpinnerAdapter(items).apply { tag = category }
        onItemSelectedListener = filterSpinnerOnItemSelectedListener
    }

    private fun brandSelected(brand: String) {
        viewModel.setSelectedBrand(brand)
    }

    private fun createSpinnerAdapter(items: List<String>) =
        ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            items
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

    private fun setupRecyclerView() {
        with(binding.mainRecyclerView) {
            adapter = compositeAdapter
            layoutManager = LinearLayoutManager(requireContext())
            itemAnimator = null
        }
    }

    private fun observe() {
        with(viewModel) {
            mainPageItems.observe(viewLifecycleOwner) {
                compositeAdapter.submitList(it)
            }
            selectedCategoryTag.observe(viewLifecycleOwner) {
                categoriesAdapter.setSelectedItem(it)
            }
            brands.observe(viewLifecycleOwner) {
                this@MainFragment.brandsFilterItems = it
            }
            prices.observe(viewLifecycleOwner) {
                this@MainFragment.pricesFilterItems = it
            }
            sizes.observe(viewLifecycleOwner) {
                this@MainFragment.sizesFilterItems = it
            }
        }
    }
}