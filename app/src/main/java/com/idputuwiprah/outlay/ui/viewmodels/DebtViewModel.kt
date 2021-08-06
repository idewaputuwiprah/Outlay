package com.idputuwiprah.outlay.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idputuwiprah.outlay.data.OutlayRepository
import com.idputuwiprah.outlay.data.entity.Debt
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DebtViewModel @Inject constructor(private val repository: OutlayRepository): ViewModel() {
    private val _debts = MutableLiveData<List<Debt>>()
    val debts: LiveData<List<Debt>> = _debts

    fun getAllDebtsByStatus(status: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _debts.postValue(repository.getDebtByStatus(status))
        }
    }
}