package com.idputuwiprah.outlay.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.idputuwiprah.outlay.data.entity.Debt
import com.idputuwiprah.outlay.databinding.ItemDebtBinding
import com.idputuwiprah.outlay.databinding.ItemListBinding
import com.idputuwiprah.outlay.other.Constants.LUNAS
import com.idputuwiprah.outlay.other.toCurrency
import java.lang.StringBuilder

class DebtAdapter: RecyclerView.Adapter<DebtAdapter.DebtViewHolder>() {
    class DebtViewHolder(private val binding: ItemDebtBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(debt: Debt) {
            with(binding) {
                tvItemName.text = debt.debtName
                tvItemDate.text = debt.date
                val currency = debt.nominal.toString().toCurrency()
                tvNominal.text = StringBuilder("Rp $currency")
            }
        }
    }

    private val diffCallback = object : DiffUtil.ItemCallback<Debt>() {
        override fun areItemsTheSame(oldItem: Debt, newItem: Debt): Boolean {
            return oldItem.debtId == newItem.debtId
        }

        override fun areContentsTheSame(oldItem: Debt, newItem: Debt): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var debts: List<Debt>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DebtViewHolder {
        val itemBinding = ItemDebtBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DebtViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: DebtViewHolder, position: Int) {
        val debt = debts[position]
        if (debt.status != LUNAS) holder.bind(debt)
    }

    override fun getItemCount(): Int = debts.size
}