package com.idputuwiprah.outlay.data

import androidx.lifecycle.LiveData
import com.idputuwiprah.outlay.data.entity.Category
import com.idputuwiprah.outlay.data.entity.Debt
import com.idputuwiprah.outlay.data.entity.Expense
import com.idputuwiprah.outlay.data.entity.Income

interface OutlayDataSource {
    //Category
    fun insertCategory(category: Category)
    fun insertCategory(categories: List<Category>)
    fun getCategory(): List<Category>

    //Income
    fun insertIncome(income: Income)
    fun getIncome(): List<Income>

    //Expense
    fun insertExpense(expense: Expense)
    fun getExpense(): List<Expense>

    //Debt
    fun insertDebt(debt: Debt)
    fun getDebtByStatus(status: String): List<Debt>

    //Balance
    fun getExpenseBalance(): List<Int>
    fun getIncomeBalance(): List<Int>
    fun getDebtBalance(status: String): List<Int>
}