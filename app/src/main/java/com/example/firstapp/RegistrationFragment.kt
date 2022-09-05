package com.example.firstapp

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.firstapp.databinding.RegistrationFragmentBinding

class RegistrationFragment : Fragment(R.layout.registration_fragment) {
    private var _binding: RegistrationFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?): View
    {
        _binding = RegistrationFragmentBinding.inflate(inflater, container, false)
        binding.btnRegistration.setOnClickListener { regAccount() }
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun regAccount() {
        if (binding.txtEditNewLogin.text.isNotEmpty() && binding.txtEditNewPassword.text.isNotEmpty() &&
                binding.txtEditRepeatNewPassword.text.isNotEmpty())
        {
            if (binding.txtEditNewPassword.text.toString() ==
                binding.txtEditRepeatNewPassword.text.toString()){

                Toast.makeText(this.activity, "Ваш логин: ${binding.txtEditNewLogin.text}" +
                    " Ваш пароль: ${binding.txtEditNewPassword.text}", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this.activity, "Пароли не совпадают.", Toast.LENGTH_SHORT).show()
            }
        }
        else{
            Toast.makeText(this.activity, "Вы заполнили не все поля.", Toast.LENGTH_SHORT).show()
        }
    }
    private fun showPass() {
        if (binding.btnShowPass.isPressed){
            binding.txtEditNewPassword.inputType = InputType.TYPE_CLASS_TEXT
        }
    }
}
