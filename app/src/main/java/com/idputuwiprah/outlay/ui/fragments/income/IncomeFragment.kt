package com.idputuwiprah.outlay.ui.fragments.income

import android.os.Bundle
import android.view.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.idputuwiprah.outlay.R
import com.idputuwiprah.outlay.databinding.FragmentIncomeBinding
import com.idputuwiprah.outlay.other.Constants.ADD_INCOME
import com.idputuwiprah.outlay.ui.MainActivity
import com.idputuwiprah.outlay.ui.adapters.IncomeAdapter
import com.idputuwiprah.outlay.ui.viewmodels.IncomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IncomeFragment: Fragment(R.layout.fragment_income) {
    private lateinit var binding: FragmentIncomeBinding
    private lateinit var incomeAdapter: IncomeAdapter
    private val incomeViewModel: IncomeViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
    : View {
        binding = FragmentIncomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        incomeAdapter = IncomeAdapter()

        binding.apply {
            val activity = activity as MainActivity
            rvIncome.apply {
                adapter = incomeAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
            ivBack.setOnClickListener { activity.onBackPressed() }
            ivAdd.setOnClickListener { activity.toAddFragment(ADD_INCOME) }
        }

        subscribeToObserver()
    }

    private fun subscribeToObserver() {
        incomeViewModel.incomes.observe(viewLifecycleOwner) { incomes->
            incomeAdapter.incomes = incomes
        }
        incomeViewModel.isLoading.observe(viewLifecycleOwner) { isLoading->
            binding.progressBar.isVisible = isLoading
        }
    }
}