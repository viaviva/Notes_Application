package com.example.notes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.notes.R
import com.example.notes.databinding.FragmentLogInBinding
import com.example.notes.util.replaceFragment

class LogInFragment : Fragment() {

    private lateinit var binding: FragmentLogInBinding

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


        binding.logInButton.setOnClickListener {
            parentFragmentManager.replaceFragment(R.id.main_container, HomeFragment())
        }
    }
}
