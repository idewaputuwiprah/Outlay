package com.idputuwiprah.outlay.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.idputuwiprah.outlay.data.entity.Expense
import com.idputuwiprah.outlay.databinding.ItemListBinding
import com.idputuwiprah.outlay.other.toCurrency
import java.lang.StringBuilder

class ExpenseAdapter: RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder>() {
    class ExpenseViewHolder(private val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(expense: Expense) {
            with(binding) {
                tvItemName.text = expense.expenseName
                tvItemDate.text = expense.date
                val currency = expense.nominal.toString().toCurrency()
                tvNominal.text = StringBuilder("Rp $currency")
            }
        }
    }

    private val diffCallback = object : DiffUtil.ItemCallback<Expense>() {
        override fun areItemsTheSame(oldItem: Expense, newItem: Expense): Boolean {
            return oldItem.expenseId == newItem.expenseId
        }

        override fun areContentsTheSame(oldItem: Expense, newItem: Expense): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var expenses: List<Expense>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val itemBiding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExpenseViewHolder(itemBiding)
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val expense = expenses[position]
        holder.bind(expense)
    }

    override fun getItemCount(): Int = expenses.size
}