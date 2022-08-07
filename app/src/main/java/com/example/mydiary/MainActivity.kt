package com.example.mydiary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mydiary.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private val weekList = listOf(
        Monday.newInstance(),
        Tuesday.newInstance(),
        Wednesday.newInstance(),
        Thursday.newInstance(),
        Friday.newInstance(),
        Saturday.newInstance()
    )
    private val weekListTitle = listOf(
        "Понедельник",
        "Вторник",
        "Среда",
        "Четверг",
        "Пятница",
        "Суббота"
    )

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = VpAdapter(this, weekList)
        binding.vp2.adapter = adapter

        TabLayoutMediator(binding.tabWeek, binding.vp2) { tab, pos ->
            tab.text = weekListTitle[pos]//resources.getStringArray(R.array.array_week)[pos]
        }.attach()
    }
}