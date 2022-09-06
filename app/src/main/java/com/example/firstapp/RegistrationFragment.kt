package com.example.firstapp

import android.annotation.SuppressLint
import android.opengl.Visibility
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.firstapp.databinding.RegistrationFragmentBinding

class RegistrationFragment : Fragment(R.layout.registration_fragment) {
    private var _binding: RegistrationFragmentBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View
    {
        _binding = RegistrationFragmentBinding.inflate(inflater, container, false)
        binding.btnRegistration.setOnClickListener { regAccount() }
        binding.swtchShowPass.setOnClickListener { showPass() }
        binding.txtEditNewPassword.doOnTextChanged { _, _, _, _ ->  checkPass()}
        binding.txtEditRepeatNewPassword.doOnTextChanged { _, _, _, _ -> checkPass() }

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
                Toast.makeText(this.activity, "Ваш логин: ${binding.txtEditNewLogin.text}" +
                    " Ваш пароль: ${binding.txtEditNewPassword.text}", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this.activity, "Вы заполнили не все поля.", Toast.LENGTH_SHORT).show()
        }
    }
    private fun showPass() {
        if (binding.swtchShowPass.isChecked)
            binding.txtEditNewPassword.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
        else
            binding.txtEditNewPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

        binding.txtEditNewPassword.setSelection(binding.txtEditNewPassword.length())
    }
    private fun checkPass(){
        if (binding.txtEditNewPassword.text.toString() == binding.txtEditRepeatNewPassword.text.toString()){
            binding.txtPassNotEqual.isVisible
            binding.btnRegistration.isEnabled = false
        }
        else {
            binding.txtPassNotEqual.isGone
            binding.btnRegistration.isEnabled
        }
    }
}