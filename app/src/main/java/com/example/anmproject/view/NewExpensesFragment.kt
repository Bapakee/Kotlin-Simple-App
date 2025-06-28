package com.example.anmproject.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.anmproject.R
import com.example.anmproject.databinding.FragmentExpensesBinding
import com.example.anmproject.databinding.FragmentNewExpensesBinding
import com.example.anmproject.model.Budgeting
import com.example.anmproject.viewmodel.BudgetingListViewModel
import com.example.anmproject.viewmodel.DetailBudgetingViewModel
import com.example.anmproject.viewmodel.DetailExpensesViewModel


class NewExpensesFragment : Fragment() {
    private lateinit var binding: FragmentNewExpensesBinding
    private lateinit var viewModelExpenses: DetailExpensesViewModel
    private lateinit var viewModelBudgeting: BudgetingListViewModel
    var listOfBudget :ArrayList<Budgeting> =ArrayList()
    var listOfBudgetName :ArrayList<String> =ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewExpensesBinding.inflate(
            inflater,
            container, false
        )
        viewModelExpenses =
            ViewModelProvider(this).get(DetailExpensesViewModel::class.java)
        viewModelBudgeting =
            ViewModelProvider(this).get(BudgetingListViewModel::class.java)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val sharedPreferences: SharedPreferences =
            requireContext().getSharedPreferences("SETTING", Context.MODE_PRIVATE)

        val userId = sharedPreferences.getString("uuid","").toString()
        viewModelBudgeting = ViewModelProvider(this).get(BudgetingListViewModel::class.java)
        viewModelExpenses =
            ViewModelProvider(this).get(DetailExpensesViewModel::class.java)
        viewModelBudgeting.refresh(userId)
        observeViewModelBudgeting()

        super.onViewCreated(view, savedInstanceState)
        binding.buttonAdd.setOnClickListener {
            val action = NewExpensesFragmentDirections.actionExpenses()
            Navigation.findNavController(it).navigate(action)
        }

        binding.spinnerKategori.onItemSelectedListener= object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                viewModelExpenses.hitung(userId,listOfBudget[position].uuid.toString())
                observeViewModelExpenses()
                binding.textMaxBudgetNew.text = listOfBudget[position].budget.toString()
                binding.textCurrentExpensesNew.text= "0"
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}

        }
    }

    fun observeViewModelExpenses(){
        viewModelExpenses.expensesLD.observe(viewLifecycleOwner, Observer {
            binding.textCurrentExpensesNew.text=it.toString()
        })
    }


    fun observeViewModelBudgeting() {
        viewModelBudgeting.budgetingLD.observe(viewLifecycleOwner, Observer {
//            val adapter = object : ArrayAdapter<Budgeting>(
//                requireContext(),
//                android.R.layout.simple_spinner_item,
//                it
//            ){}
            for (budget in it){
                listOfBudget.add(budget)
            }
            for (budgetname in listOfBudget){
                listOfBudgetName.add(budgetname.name.toString())
            }
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            binding.spinnerKategori.adapter = listOfBudgetName
            val budgetAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item,listOfBudgetName)
            budgetAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerKategori.adapter = budgetAdapter
        })

    }
}