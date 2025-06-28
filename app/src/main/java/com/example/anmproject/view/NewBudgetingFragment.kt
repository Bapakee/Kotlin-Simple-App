package com.example.anmproject.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.anmproject.R
import com.example.anmproject.databinding.FragmentBudgetingBinding
import com.example.anmproject.databinding.FragmentNewBudgetingBinding
import com.example.anmproject.model.Budgeting
import com.example.anmproject.model.User
import com.example.anmproject.viewmodel.DetailBudgetingViewModel


class NewBudgetingFragment : Fragment() {
    private lateinit var viewModel: DetailBudgetingViewModel
    private lateinit var binding: FragmentNewBudgetingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewBudgetingBinding.inflate(
            inflater,
            container, false
        )
        viewModel =
            ViewModelProvider(this).get(DetailBudgetingViewModel::class.java)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val sharedPreferences: SharedPreferences =
            requireContext().getSharedPreferences("SETTING", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val userId = sharedPreferences.getString("uuid","")
        binding.buttonAddNewBudget.setOnClickListener {
            var budgetBaru = Budgeting(
                userId,
                binding.textNewBudgeting.text.toString(),
                binding.textNominalNewBudget.text.toString().toInt()
            )
            val list = listOf(budgetBaru)
            viewModel.addBudget(list)
            Toast.makeText(view.context, "Data added", Toast.LENGTH_LONG).show()
            Navigation.findNavController(it).popBackStack()
        }
    }
}