package com.example.anmproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.anmproject.R
import com.example.anmproject.databinding.FragmentExpensesBinding
import com.example.anmproject.databinding.FragmentNewExpensesBinding


class NewExpensesFragment : Fragment() {
    private lateinit var binding: FragmentNewExpensesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewExpensesBinding.inflate(
            inflater,
            container, false
        )
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonAdd.setOnClickListener {
            val action = NewExpensesFragmentDirections.actionExpenses()
            Navigation.findNavController(it).navigate(action)
        }
    }
}