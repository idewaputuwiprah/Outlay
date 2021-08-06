package com.idputuwiprah.outlay.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.idputuwiprah.outlay.data.entity.Income
import com.idputuwiprah.outlay.databinding.ItemListBinding
import com.idputuwiprah.outlay.other.toCurrency
import java.lang.StringBuilder

class IncomeAdapter: RecyclerView.Adapter<IncomeAdapter.IncomeViewHolder>() {
    class IncomeViewHolder(private val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(income: Income) {
            with(binding) {
                tvItemName.text = income.incomeName
                tvItemDate.text = income.date
                val currency = income.nominal.toString().toCurrency()
                tvNominal.text = StringBuilder("Rp $currency")
            }
        }
    }

    private val diffCallback = object : DiffUtil.ItemCallback<Income>() {
        override fun areItemsTheSame(oldItem: Income, newItem: Income): Boolean {
            return oldItem.incomeId == newItem.incomeId
        }

        override fun areContentsTheSame(oldItem: Income, newItem: Income): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

    }
    private val differ = AsyncListDiffer(this, diffCallback)

    var incomes: List<Income>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncomeViewHolder {
        val itemBinding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return IncomeViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: IncomeViewHolder, position: Int) {
        val income = incomes[position]
        holder.bind(income)
    }

    override fun getItemCount(): Int = incomes.size
}