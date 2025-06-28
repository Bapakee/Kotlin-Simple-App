package com.example.anmproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anmproject.databinding.FragmentReportBinding
import com.example.anmproject.viewmodel.ListViewModel


class ReportFragment : Fragment() {

    private lateinit var viewModel:ListViewModel
    private val expensesListAdapter  = ExpensesListAdapter(arrayListOf())
    private lateinit var binding: FragmentReportBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReportBinding.inflate(inflater,container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        binding.recViewBudgeting.layoutManager = LinearLayoutManager(context)
        binding.recViewBudgeting.adapter = expensesListAdapter

        observeViewModel()
    }
    fun observeViewModel() {
        viewModel.expensesLD.observe(viewLifecycleOwner, Observer {
            expensesListAdapter.updateStudentList(it)
        })
    }


}