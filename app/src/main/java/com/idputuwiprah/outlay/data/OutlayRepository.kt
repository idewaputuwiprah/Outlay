package com.idputuwiprah.outlay.data

import androidx.lifecycle.LiveData
import com.idputuwiprah.outlay.data.entity.Category
import com.idputuwiprah.outlay.data.entity.Debt
import com.idputuwiprah.outlay.data.entity.Expense
import com.idputuwiprah.outlay.data.entity.Income
import javax.inject.Inject

class OutlayRepository @Inject constructor(private val outlayDao: OutlayDao): OutlayDataSource {
    //Category

    override fun insertCategory(category: Category) {
        outlayDao.insertCategory(category)
    }

    override fun insertCategory(categories: List<Category>) {
        outlayDao.insertCategory(categories)
    }

    override fun getCategory(): List<Category> = outlayDao.getAllCategory()

    //Income

    override fun insertIncome(income: Income) {
        outlayDao.insertIncome(income)
    }

    override fun getIncome(): List<Income> = outlayDao.getAllIncome()

    //Expense

    override fun insertExpense(expense: Expense) {
        outlayDao.insertExpense(expense)
    }

    override fun getExpense(): List<Expense> = outlayDao.getAllExpense()

    //Debt

    override fun insertDebt(debt: Debt) {
        outlayDao.insertDebt(debt)
    }

    override fun getDebtByStatus(status: String): List<Debt> = outlayDao.getDebtWithStatus(status)

    //Balance

    override fun getExpenseBalance(): List<Int> = outlayDao.getExpenseBalance()

    override fun getIncomeBalance(): List<Int> = outlayDao.getIncomeBalance()

    override fun getDebtBalance(status: String): List<Int> = outlayDao.getDebtBalance(status)
}