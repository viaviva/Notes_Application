package com.example.notes.ui.signUp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.notes.R
import com.example.notes.databinding.FragmentSignUpBinding
import com.example.notes.model.User
import com.example.notes.repositories.SharedPreferenceRepository
import com.example.notes.ui.HomeFragment
import com.example.notes.ui.logIn.LogInFragment
import com.example.notes.util.replaceFragment

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding

    private val viewModel: SignUpViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginText.setOnClickListener {
            parentFragmentManager.replaceFragment(R.id.main_container, LogInFragment())
        }

        binding.signUpButton.setOnClickListener {
            isUserExist(binding.emailInputEditText.text.toString())
        }
    }

    private fun addUser() {
        binding.run {
            viewModel.addUser(
                User(
                    firstNameInputEditText.text.toString(),
                    lastNameInputEditText.text.toString(),
                    emailInputEditText.text.toString(),
                    passwordInputEditText.text.toString()
                )
            )
        }

        SharedPreferenceRepository.run {
            setIsUserLogIn(true)
            setUserEmail(binding.emailInputEditText.text.toString())
        }
    }

    private fun isUserExist(email: String) {
        if (!viewModel.getUserByEmail(email)) {
            binding.emailInputEditText.error =
                requireContext().getString(R.string.email_exist)
        } else {
            addUser()
            parentFragmentManager.replaceFragment(R.id.main_container, HomeFragment())
        }
    }
}
