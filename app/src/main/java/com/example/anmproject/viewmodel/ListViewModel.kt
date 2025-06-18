package com.example.anmproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.anmproject.model.Budgeting

class ListViewModel:ViewModel() {
    val expensesLD = MutableLiveData<ArrayList<Budgeting>>()
    val expensesLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    fun refresh() {

        expensesLoadErrorLD.value = false
        loadingLD.value = false
    }

}

