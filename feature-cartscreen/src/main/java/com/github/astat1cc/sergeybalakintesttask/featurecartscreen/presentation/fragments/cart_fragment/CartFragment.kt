package com.github.astat1cc.sergeybalakintesttask.featurecartscreen.presentation.fragments.cart_fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.databinding.FragmentCartBinding
import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.presentation.fragments.cart_fragment.recyclerview.CartItemsAdapter
import com.github.astat1cc.sergeybalakintesttask.featurecartscreen.presentation.fragments.cart_fragment.viewmodel.CartViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding
    private val viewModel: CartViewModel by viewModel<CartViewModel>()
    private val adapter: CartItemsAdapter by lazy { CartItemsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backImageView.setOnClickListener { requireActivity().onBackPressed() }

        observe()
        setupRecyclerView()
    }

    private fun observe() {
        with(viewModel) {
            cartItems.observe(viewLifecycleOwner) {
                if (it.isEmpty()) {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                } else {
                    binding.progressBar.visibility = View.GONE
                    binding.recyclerView.visibility = View.VISIBLE
                }
                adapter.currentList = it
            }
            total.observe(viewLifecycleOwner) {
                binding.totalTextView.text = it.toPriceFormat()
            }
            delivery.observe(viewLifecycleOwner) {
                binding.deliveryTextView.text = it
            }
        }
    }

    private fun setupRecyclerView() {
        with(binding.recyclerView) {
            adapter = this@CartFragment.adapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun Int.toPriceFormat(): String =
        if (this >= 1000) {
            "$%.${3}f us".format(this / 1000.0)
        } else "$$this us"
}


