package com.idputuwiprah.outlay.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.idputuwiprah.outlay.R
import com.idputuwiprah.outlay.databinding.FragmentExpenseBinding
import com.idputuwiprah.outlay.ui.MainActivity
import com.idputuwiprah.outlay.ui.adapters.ExpenseAdapter
import com.idputuwiprah.outlay.ui.viewmodels.ExpenseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExpenseFragment: Fragment(R.layout.fragment_expense) {
    private lateinit var binding: FragmentExpenseBinding
    private lateinit var expenseAdapter: ExpenseAdapter
    private val expenseViewModel: ExpenseViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentExpenseBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        expenseAdapter = ExpenseAdapter()

        binding.apply {
            rvExpense.apply {
                adapter = expenseAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
            ivBack.setOnClickListener { (activity as MainActivity).onBackPressed() }
        }

        subscribeToObserver()
    }

    private fun subscribeToObserver() {
        expenseViewModel.expenses.observe(viewLifecycleOwner) { expenses ->
            expenseAdapter.expenses = expenses
        }
    }
}