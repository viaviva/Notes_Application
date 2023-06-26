package com.example.notes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.notes.R
import com.example.notes.databinding.FragmentMainBinding
import com.example.notes.ui.logIn.LogInFragment
import com.example.notes.ui.onboarding.OnboardingFragment
import com.example.notes.util.replaceFragment

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.discoverButton.setOnClickListener {
            parentFragmentManager.replaceFragment(R.id.main_container, OnboardingFragment())
        }

        binding.loginText.setOnClickListener {
            parentFragmentManager.replaceFragment(R.id.main_container, LogInFragment())
        }
    }
}
