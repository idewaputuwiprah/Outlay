package com.idputuwiprah.outlay.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idputuwiprah.outlay.data.OutlayRepository
import com.idputuwiprah.outlay.data.entity.Expense
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExpenseViewModel @Inject constructor(private val repository: OutlayRepository) : ViewModel() {
    private val _expenses = MutableLiveData<List<Expense>>()
    val expenses: LiveData<List<Expense>> = _expenses

    init {
        getAllExpense()
    }

    private fun getAllExpense() {
        viewModelScope.launch(Dispatchers.IO) {
            _expenses.postValue(repository.getExpense())
        }
    }
}