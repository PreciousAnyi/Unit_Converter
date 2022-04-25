package com.project.unitconverter.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.project.unitconverter.fragments.CalculatorFragment
import com.project.unitconverter.fragments.ExchangeRateFragment
import com.project.unitconverter.fragments.UnitConverterFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        // Tells how many fragments we have
        return 3
    }

    // Returns specific fragments based on position
    override fun createFragment(position: Int): Fragment {
       return when(position) {
            0 -> {
                CalculatorFragment()
            }
            1 -> {
                ExchangeRateFragment()
            }
            2 -> {
                UnitConverterFragment()
            }
            else -> {
                Fragment()
            }
        }
    }
}