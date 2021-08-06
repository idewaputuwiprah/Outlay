package com.idputuwiprah.outlay.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.idputuwiprah.outlay.data.entity.Category
import com.idputuwiprah.outlay.data.entity.Debt
import com.idputuwiprah.outlay.data.entity.Expense
import com.idputuwiprah.outlay.data.entity.Income
import com.idputuwiprah.outlay.data.entity.relations.CategoryWithDebts
import com.idputuwiprah.outlay.data.entity.relations.CategoryWithExpenses
import com.idputuwiprah.outlay.data.entity.relations.CategoryWithIncomes

@Dao
interface OutlayDao {

    //Category

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(category: Category)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(categories: List<Category>)

    @Update
    fun updateCategory(category: Category)

    @Delete
    fun deleteCategory(category: Category)

    @Query("SELECT * FROM category ORDER BY category_id ASC")
    fun getAllCategory(): List<Category>

    //Debt

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDebt(debt: Debt)

    @Update
    fun updateDebt(debt: Debt)

    @Delete
    fun deleteDebt(debt: Debt)

    @Query("SELECT * FROM debt ORDER BY debt_id ASC")
    fun getAllDebts(): List<Debt>

    @Query("SELECT * FROM debt WHERE status = :status")
    fun getDebtWithStatus(status: String): List<Debt>

    @Transaction
    @Query("SELECT * FROM category WHERE category_id = :categoryId")
    fun getCategoryWithDebt(categoryId: Int): List<CategoryWithDebts>

    //Expense

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertExpense(expense: Expense)

    @Update
    fun updateExpense(expense: Expense)

    @Delete
    fun deleteExpense(expense: Expense)

    @Query("SELECT * FROM expense ORDER BY expense_id ASC")
    fun getAllExpense(): List<Expense>

    @Transaction
    @Query("SELECT * FROM category WHERE category_id = :categoryId")
    fun getCategoryWithExpenses(categoryId: Int): List<CategoryWithExpenses>

    //Income

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertIncome(income: Income)

    @Update
    fun updateIncome(income: Income)

    @Delete
    fun deleteIncome(income: Income)

    @Query("SELECT * FROM income ORDER BY income_id ASC")
    fun getAllIncome(): List<Income>

    @Transaction
    @Query("SELECT * FROM category WHERE category_id = :categoryId")
    fun getCategoryWithIncome(categoryId: Int): List<CategoryWithIncomes>

    // Balance

    @Query("SELECT nominal FROM income")
    fun getIncomeBalance(): List<Int>

    @Query("SELECT nominal FROM expense")
    fun getExpenseBalance(): List<Int>

    @Query("SELECT nominal FROM debt WHERE status = :status")
    fun getDebtBalance(status: String): List<Int>
}