package com.example.anmproject.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
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
            viewModel.cekUsername(list[0].username.toString())
            val cek = observeViewModel(list)
            if (cek == true){
                Toast.makeText(view.context, "Data added", Toast.LENGTH_LONG).show()
                Navigation.findNavController(it).popBackStack()
            }
        }
    }
    fun observeViewModel(list: List<User>): Boolean {
        var cek = false
        viewModel.userLD.observe(viewLifecycleOwner, Observer {
            if (it != null){
                Toast.makeText(context,"Error ! Username Sudah ada",Toast.LENGTH_SHORT).show()
                cek = false
            }else{
                viewModel.addTodo(list)
                cek = true
            }

        })
        return cek
    }
}