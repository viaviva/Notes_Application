package com.example.notes.ui.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.notes.ui.onboarding.OnbordingStepFragment.Companion.getOnboardingStepFragment

class OnboardingAdapter(fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager) {

    private val listFragment =
        arrayListOf(
            getOnboardingStepFragment(1),
            getOnboardingStepFragment(2),
            getOnboardingStepFragment(3)
        )

    override fun getCount(): Int = listFragment.size

    override fun getItem(position: Int): Fragment = listFragment[position]
}