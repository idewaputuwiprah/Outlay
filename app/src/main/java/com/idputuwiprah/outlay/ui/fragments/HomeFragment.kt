package com.idputuwiprah.outlay.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.idputuwiprah.outlay.R
import com.idputuwiprah.outlay.databinding.FragmentHomeBinding
import com.idputuwiprah.outlay.other.toCurrency
import com.idputuwiprah.outlay.ui.MainActivity
import com.idputuwiprah.outlay.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.lang.StringBuilder

@AndroidEntryPoint
class HomeFragment: Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToObserver()

        binding.apply {
            cvIncome.setOnClickListener {
                (activity as MainActivity).toIncomeFragment()
            }
            cvExpense.setOnClickListener {
                (activity as MainActivity).toExpenseFragment()
            }
            cvDebt.setOnClickListener {
                (activity as MainActivity).toDebtFragment()
            }
        }
    }

    private fun subscribeToObserver() {
        mainViewModel.balance.observe(viewLifecycleOwner) {
            val currency = it.toString()
            binding.tvBalance.text = StringBuilder("Rp ${currency.toCurrency()}")
        }
    }
}