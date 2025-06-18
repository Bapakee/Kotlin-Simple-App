package com.example.anmproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.anmproject.model.Budgeting

class BudgetingListViewModel:ViewModel() {
    val budgetingLD = MutableLiveData<ArrayList<Budgeting>>()
    val budgetingLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    fun refresh() {

        budgetingLoadErrorLD.value = false
        loadingLD.value = false
    }
}