package com.example.notes.ui.logIn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.notes.R
import com.example.notes.databinding.FragmentLogInBinding
import com.example.notes.repositories.SharedPreferenceRepository
import com.example.notes.ui.HomeFragment
import com.example.notes.ui.signUp.SignUpFragment
import com.example.notes.util.getText
import com.example.notes.util.replaceFragment

class LogInFragment : Fragment() {

    private lateinit var binding: FragmentLogInBinding

    private val viewModel: LogInViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLogInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signupText.setOnClickListener {
            parentFragmentManager.replaceFragment(R.id.main_container, SignUpFragment())
        }

        binding.run {
            logInButton.setOnClickListener {
                isUserExist(
                    emailTextInputLayout.getText(),
                    passwordTextInputLayout.getText()
                )
            }
        }
    }

    private fun isUserExist(email: String, password: String) {

        if (viewModel.getUser(email, password)) {
            binding.emailTextInputLayout.error =
                requireContext().getString(R.string.user_invalid)
        } else {
            SharedPreferenceRepository.run {
                setIsUserLogIn(true)
                setUserEmail(email)
            }
            parentFragmentManager.replaceFragment(R.id.main_container, HomeFragment())
        }

    }

}
