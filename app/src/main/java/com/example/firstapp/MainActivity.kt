package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.firstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navigate(LoginFragment())
        binding.btnAuthPage.isEnabled = false
        binding.btnAuthPage.setOnClickListener {
            navigate(LoginFragment())
            binding.btnAuthPage.isEnabled = false
            binding.btnRegPage.isEnabled = true
        }
        binding.btnRegPage.setOnClickListener {
            navigate(RegistrationFragment())
            binding.btnRegPage.isEnabled = false
            binding.btnAuthPage.isEnabled = true
        }

    }

    private fun navigate (fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentAuthReg,fragment)
        fragmentTransaction.commit()
    }
    }