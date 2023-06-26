package com.example.notes.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.notes.R
import com.example.notes.databinding.FragmentProfileBinding
import com.example.notes.repositories.SharedPreferenceRepository
import com.example.notes.ui.logIn.LogInFragment
import com.example.notes.util.replaceFragment

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.profileNameTextView.text = SharedPreferenceRepository.getUserEmail()

        binding.logOutTextView.setOnClickListener {
            logOut()
        }

        binding.deleteProfileButton.setOnClickListener {
            viewModel.deleteProfile(SharedPreferenceRepository.getUserEmail())
            logOut()
        }
    }

    private fun logOut() {
        SharedPreferenceRepository.clearUserPreference()
        parentFragmentManager.replaceFragment(R.id.main_container, LogInFragment(), false)
    }
}