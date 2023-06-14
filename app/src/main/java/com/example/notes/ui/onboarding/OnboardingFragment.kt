package com.example.notes.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.notes.R
import com.example.notes.databinding.FragmentOnboardingBinding
import com.example.notes.ui.SignUpFragment

class OnboardingFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.skipText.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_container, SignUpFragment())
                .commit()
        }

        binding.viewPager.adapter = OnboardingAdapter(parentFragmentManager)
        binding.circleIndicator.setViewPager(binding.viewPager)
    }
}
