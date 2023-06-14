package com.example.notes.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.notes.R
import com.example.notes.databinding.FragmentOnboardingStepBinding

private const val STEP_EXTRA = "stepExtra"

private const val STEP_1 = 1
private const val STEP_2 = 2
private const val STEP_3 = 3

class OnbordingStepFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingStepBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnboardingStepBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val step = arguments?.getInt(STEP_EXTRA) ?: STEP_1

        when (step) {
            STEP_1 -> {
                binding.onboardingText.setText(R.string.first_onboarding_info_text)
                binding.imageView.setImageResource(R.drawable.first_onboarding_illustration)
            }

            STEP_2 -> {
                binding.onboardingText.setText(R.string.second_onboarding_info_text)
                binding.imageView.setImageResource(R.drawable.second_onboarding_illustration)
            }

            STEP_3 -> {
                binding.onboardingText.setText(R.string.third_onboarding_info_text)
                binding.imageView.setImageResource(R.drawable.third_onboarding_illustration)
            }
        }
    }

    companion object {
        fun getOnboardingStepFragment(stepNumber: Int): OnbordingStepFragment {
            return OnbordingStepFragment().apply {
                arguments = bundleOf(STEP_EXTRA to stepNumber)
            }
        }
    }
}