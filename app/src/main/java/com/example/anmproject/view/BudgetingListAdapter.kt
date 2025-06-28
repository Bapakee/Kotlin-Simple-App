package com.example.anmproject.view

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.anmproject.databinding.BudgetingListItemBinding
import com.example.anmproject.model.Budgeting

class BudgetingListAdapter (val budgetingList:ArrayList<Budgeting>)
:RecyclerView.Adapter<BudgetingListAdapter.BudgetingViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BudgetingViewHolder {
        var binding = BudgetingListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent,false)
        return BudgetingViewHolder(binding)

    }

    override fun onBindViewHolder(
        holder: BudgetingViewHolder,
        position: Int
    ) {
        holder.binding.textKategoriBudgeting.text = budgetingList[position].name
        holder.binding.textNominalBudgeting.text = budgetingList[position].budget.toString()
    }

    override fun getItemCount(): Int {
        return budgetingList.size
    }

    class BudgetingViewHolder(var binding: BudgetingListItemBinding):
        RecyclerView.ViewHolder(binding.root)

    fun updateTodoList(newBudgetingList: List<Budgeting>) {
        budgetingList.clear()
        budgetingList.addAll(newBudgetingList)
        notifyDataSetChanged()
    }

}
