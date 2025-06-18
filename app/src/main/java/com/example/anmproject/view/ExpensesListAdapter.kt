package com.example.anmproject.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.anmproject.databinding.ExpensesListItemBinding
import com.example.anmproject.model.Expenses
import com.example.anmproject.model.User

class ExpensesListAdapter (val expensesList:ArrayList<Expenses>)
    :RecyclerView.Adapter<ExpensesListAdapter.ExpensesViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExpensesViewHolder {
        val binding = ExpensesListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return ExpensesViewHolder(binding)

    }

    override fun onBindViewHolder(
        holder: ExpensesViewHolder,
        position: Int
    ) {
        holder.binding.textNominalExpenses.text = expensesList[position].nominal
        holder.binding.textKategori.text = expensesList[position].idBudgeting
        holder.binding.textTanggalExpenses.text = expensesList[position].tanggal


        fun updateStudentList(newExpensesList: ArrayList<Expenses>) {
            expensesList.clear()
            expensesList.addAll(newExpensesList)
            notifyDataSetChanged()
        }


    }

    override fun getItemCount(): Int {
        return expensesList.size
    }

    class ExpensesViewHolder (var binding: ExpensesListItemBinding)
        :RecyclerView.ViewHolder(binding.root)
    }