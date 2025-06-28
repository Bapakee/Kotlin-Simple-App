package com.example.anmproject.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anmproject.R
import com.example.anmproject.databinding.FragmentExpensesBinding
import com.example.anmproject.databinding.FragmentLoginBinding
import com.example.anmproject.viewmodel.BudgetingListViewModel
import com.example.anmproject.viewmodel.ExpensesListViewModel


class ExpensesFragment : Fragment() {
    private lateinit var binding: FragmentExpensesBinding
    private lateinit var viewModel: ExpensesListViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentExpensesBinding.inflate(
            inflater,
            container, false
        )
        viewModel =
            ViewModelProvider(this).get(ExpensesListViewModel::class.java)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences: SharedPreferences =
        requireContext().getSharedPreferences("SETTING", Context.MODE_PRIVATE)
        val userId = sharedPreferences.getString("uuid","").toString()

        viewModel = ViewModelProvider(this).get(ExpensesListViewModel::class.java)
        viewModel.refresh(userId)
        binding.recViewExpenses.layoutManager = LinearLayoutManager(context)


        binding.fabExpenses.setOnClickListener {
            val action = ExpensesFragmentDirections.actionNewExpenses()
            Navigation.findNavController(it).navigate(action)
        }
    }

}