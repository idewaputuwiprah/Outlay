package com.idputuwiprah.outlay.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.idputuwiprah.outlay.R
import com.idputuwiprah.outlay.databinding.FragmentDebtBinding
import com.idputuwiprah.outlay.ui.MainActivity
import com.idputuwiprah.outlay.ui.adapters.DebtAdapter
import com.idputuwiprah.outlay.ui.viewmodels.DebtViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DebtFragment: Fragment(R.layout.fragment_debt) {
    private lateinit var binding: FragmentDebtBinding
    private lateinit var debtAdapter: DebtAdapter
    private val debtViewModel: DebtViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentDebtBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        debtAdapter = DebtAdapter()

        binding.apply {
            rvDebt.apply {
                adapter = debtAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
            ivBack.setOnClickListener { (activity as MainActivity).onBackPressed() }
        }

        subscribeToObserver()
    }

    private fun subscribeToObserver() {
        debtViewModel.debts.observe(viewLifecycleOwner) { debts->
            debtAdapter.debts = debts
        }
    }
}