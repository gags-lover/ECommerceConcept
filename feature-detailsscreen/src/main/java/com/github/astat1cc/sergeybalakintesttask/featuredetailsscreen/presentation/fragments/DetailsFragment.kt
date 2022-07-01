package com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.presentation.fragments

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.R
import com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.databinding.FragmentDetailsBinding
import com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.domain.entities.ProductDetails
import com.github.astat1cc.sergeybalakintesttask.featuredetailsscreen.presentation.fragments.viewmodel.DetailsViewModel
import com.github.astat1cc.sergeybalakintesttask.navigation.AppRoutes
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val viewModel by viewModel<DetailsViewModel>()

    private var colorImageViews: List<ImageView> = emptyList()
    private var capacityTextViews: List<TextView> = emptyList()

    private lateinit var chosenColorImageView: ImageView
    private lateinit var chosenCapacityTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupColorAndCapacityViews()
        observe()
    }

    private fun setupColorAndCapacityViews() {
        chosenColorImageView = binding.firstColorImageView
        chosenCapacityTextView = binding.firstCapacity
        colorImageViews = with(binding) {
            listOf(firstColorImageView, secondColorImageView, thirdColorImageView)
        }
        capacityTextViews = with(binding) {
            listOf(firstCapacity, secondCapacity, thirdCapacity)
        }
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        setColorsClickListener()
        setCapacityClickListener()
        setBackViewClickListener()
        setCartClickListener()
    }

    private fun setCartClickListener() {
        binding.cartImageView.setOnClickListener {
            findNavController().navigate(AppRoutes.CartScreen.Entry)
        }
    }

    private fun setBackViewClickListener() {
        binding.backImageView.setOnClickListener { requireActivity().onBackPressed() }
    }

    private fun setCapacityClickListener() {
        capacityTextViews.forEach { capacityTextView ->
            capacityTextView.setOnClickListener {
                unselectChosenCapacity()
                selectCapacity(it as TextView)
            }
        }
    }

    private fun setColorsClickListener() {
        colorImageViews.forEach { colorImageView ->
            colorImageView.setOnClickListener {
                unselectChosenColor()
                selectColor(it as ImageView)
            }
        }
    }

    private fun selectCapacity(capacityToSelect: TextView) {
        with(capacityToSelect) {
            backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(requireContext(), R.color.orange))
            setTextColor(Color.WHITE)
        }
        chosenCapacityTextView = capacityToSelect
    }

    private fun unselectChosenCapacity() {
        with(chosenCapacityTextView) {
            backgroundTintList = null
            setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_grey))
        }
    }

    private fun selectColor(colorToSelect: ImageView) {
        colorToSelect.setImageResource(R.drawable.ic_selected)
        chosenColorImageView = colorToSelect
    }

    private fun unselectChosenColor() {
        chosenColorImageView.setImageDrawable(null)
    }

    private fun observe() {
        with(viewModel) {
            productDetails.observe(viewLifecycleOwner) {
                updateUi(it)
            }
        }
    }

    private fun updateUi(details: ProductDetails) {
        with(binding) {
            titleTextView.text = details.title
            ratingBar.rating = details.rating.toFloat()
            cpuTextView.text = details.cpu
            cameraTextView.text = details.camera
            ramTextView.text = details.ram
            sdTextView.text = details.sd
            favouriteImageView.setImageResource(
                if (details.isFavorites) {
                    R.drawable.ic_favorite
                } else {
                    R.drawable.ic_favorite_border
                }
            )
            handleColorAndCapacity(details)
        }
    }

    private fun handleColorAndCapacity(details: ProductDetails) {
        details.color.forEachIndexed { i, color ->
            with(colorImageViews[i]) {
                makeVisible()
                backgroundTintList = ColorStateList.valueOf(Color.parseColor(color))
            }
        }
        details.capacity.forEachIndexed { i, capacity ->
            with(capacityTextViews[i]) {
                makeVisible()
                text = "$capacity GB"
            }
        }
    }

    private fun View.makeVisible() {
        visibility = View.VISIBLE
    }
}