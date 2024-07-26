package com.gkuziel.skyrssreader.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.gkuziel.skyrssreader.R
import com.gkuziel.skyrssreader.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.state.observe(this) {

            Log.d("dfsd", it.firstOrNull()?.text ?:"")
        }
        initViews()
    }

    private fun initViews() {
        with(binding) {
            btnLoadFeed.setOnClickListener {
                viewModel.loadData()
            }
            btnClearFeed.setOnClickListener {
                viewModel.clearData()
            }
        }
    }
}