package com.idputuwiprah.outlay.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idputuwiprah.outlay.data.OutlayRepository
import com.idputuwiprah.outlay.data.entity.Income
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class IncomeViewModel @Inject constructor(private val repository: OutlayRepository) : ViewModel() {
    private val _incomes = MutableLiveData<List<Income>>()
    val incomes: LiveData<List<Income>> = _incomes

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        getAllIncome()
    }

    private fun insertDefaultIncome() {
        val income = Income(
            incomeName = "Gaji Kerja",
            nominal = 5000000,
            categoryId = 1,
            date = "07-08-2021"
        )
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertIncome(income)
        }
    }

    private fun getAllIncome() {
        viewModelScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main) {_isLoading.value = true}
            _incomes.postValue(repository.getIncome())
            withContext(Dispatchers.Main) {_isLoading.value = false}
        }
    }
}