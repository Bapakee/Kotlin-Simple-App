package com.example.anmproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.anmproject.model.Expenses

class ExpensesListViewModel:ViewModel() {
    val expensesLD = MutableLiveData<ArrayList<Expenses>>()
    val expensesLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    fun refresh() {

        expensesLoadErrorLD.value = false
        loadingLD.value = false
    }
}