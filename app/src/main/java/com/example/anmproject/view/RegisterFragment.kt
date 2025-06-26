package com.example.anmproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.anmproject.databinding.FragmentRegisterBinding
import com.example.anmproject.model.User
import com.example.anmproject.viewmodel.DetailUserViewModel

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var viewModel: DetailUserViewModel

    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        viewModel =
            ViewModelProvider(this).get(DetailUserViewModel::class.java)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonCreate.setOnClickListener {
            var user = User(
                binding.textUsername.text.toString(),
                binding.textFirstName.text.toString(),
                binding.textLastName.text.toString(),
                binding.textPassword.text.toString()
            )
            val list = listOf(user)
            viewModel.addTodo(list)
            Toast.makeText(view.context, "Data added", Toast.LENGTH_LONG).show()
            Navigation.findNavController(it).popBackStack()
        }
    }
}