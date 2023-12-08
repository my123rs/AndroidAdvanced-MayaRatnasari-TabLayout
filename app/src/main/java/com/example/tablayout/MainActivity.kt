package com.example.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tablayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPageAdapter: ViewPageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        viewPageAdapter = ViewPageAdapter(supportFragmentManager, lifecycle)

        with(binding) {
            viewPager.adapter = viewPageAdapter

            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                when(position){
                    0 -> tab.text = "Nama Profile"
                    1 -> tab.text = "Nama Kdrama"
                }
            }.attach()
        }
    }
}