package com.idputuwiprah.outlay.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idputuwiprah.outlay.data.OutlayRepository
import com.idputuwiprah.outlay.data.entity.Category
import com.idputuwiprah.outlay.other.Constants.LUNAS
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: OutlayRepository): ViewModel() {

    private val _categories = MutableLiveData<List<Category>>()
    val categories: LiveData<List<Category>> = _categories

    private val _balance = MutableLiveData<Int>()
    val balance: LiveData<Int> = _balance

    init {
        getAllCategory()
        getBalance()
    }

    private fun insertDefaultCategory() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertCategory(Category(categoryName = "Makan/Minum"))
            repository.insertCategory(Category(categoryName = "Hobi"))
            repository.insertCategory(Category(categoryName = "Elektronik"))
            repository.insertCategory(Category(categoryName = "Pendidikan"))
            repository.insertCategory(Category(categoryName = "Lainnya"))

            _categories.postValue(repository.getCategory())
        }
    }

    private fun getAllCategory() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getCategory()
            if (data.isNotEmpty()) _categories.postValue(repository.getCategory())
            else insertDefaultCategory()
        }
    }

    private fun getBalance() {
        viewModelScope.launch(Dispatchers.IO) {
            var totalBalance = 0
            val expensesBalance = repository.getExpenseBalance()
            val incomesBalance = repository.getIncomeBalance()
            val debtsBalance = repository.getDebtBalance(LUNAS)

            if (incomesBalance.isNotEmpty()) {
                incomesBalance.forEach { balances ->
                    totalBalance += balances
                }
            }

            if (expensesBalance.isNotEmpty()) {
                expensesBalance.forEach { balances ->
                    totalBalance -= balances
                }
            }

            if (debtsBalance.isNotEmpty()) {
                debtsBalance.forEach { balances ->
                    totalBalance -= balances
                }
            }

            _balance.postValue(totalBalance)
        }
    }
}