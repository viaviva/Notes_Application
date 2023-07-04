package com.example.notes.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.notes.R
import com.example.notes.databinding.FragmentProfileBinding
import com.example.notes.repositories.SharedPreferenceRepository
import com.example.notes.ui.logIn.LogInFragment
import com.example.notes.util.replaceFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    private val viewModel: ProfileViewModel by viewModels()

    @Inject
    lateinit var sharedPreferences: SharedPreferenceRepository

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

        binding.profileNameTextView.text = sharedPreferences.getUserEmail()

        viewModel.run {
            allNotesDeleted = {
                binding.root.post {
                    Toast.makeText(requireContext(), R.string.all_notes_deleted, Toast.LENGTH_LONG)
                        .show()
                }
            }
            countOfNotes.observe(viewLifecycleOwner) {
                binding.notesTextView.text = "$it notes"
            }
            getCountOfNotes()
        }

        binding.run {
            logOutTextView.setOnClickListener {
                logOut()
            }

            deleteAllNotesTextView.setOnClickListener {
                viewModel.deleteAllNotes()
            }

            deleteProfileButton.setOnClickListener {
                viewModel.deleteProfile()
                logOut()
            }
        }
    }

    private fun logOut() {
        sharedPreferences.clearUserPreference()
        parentFragmentManager.replaceFragment(R.id.main_container, LogInFragment(), false)
    }
}