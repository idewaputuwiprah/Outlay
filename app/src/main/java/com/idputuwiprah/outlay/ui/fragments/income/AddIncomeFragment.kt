package com.idputuwiprah.outlay.ui.fragments.income

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.idputuwiprah.outlay.R
import com.idputuwiprah.outlay.databinding.FragmentAddIncomeBinding
import com.idputuwiprah.outlay.ui.MainActivity

class AddIncomeFragment: Fragment(R.layout.fragment_add_income) {
    private lateinit var binding: FragmentAddIncomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddIncomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            val activity = activity as MainActivity
            ivBack.setOnClickListener { activity.onBackPressed() }
        }
    }
}