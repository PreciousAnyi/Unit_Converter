package com.project.unitconverter

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.project.unitconverter.adapter.ViewPagerAdapter

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager2 = findViewById<ViewPager2>(R.id.view_pager_2)

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        viewPager2.adapter = adapter

        TabLayoutMediator(tabLayout,viewPager2){
            tab,position ->
            when(position){
                0 -> {
                    tab.text = "Calculator"
                }
                1 -> {
                    tab.text = "Exchange Rate"
                }
                2 -> {
                    tab.text = "Unit Converter"
                }
            }
        }.attach()


    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}