package com.gkuziel.skyrssreader.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gkuziel.skyrssreader.R
import com.gkuziel.skyrssreader.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val rssItemAdapter by lazy { RssItemAdapter(this) }
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()

        viewModel.state.observe(this) {
            rssItemAdapter.setItems(it)
        }
    }

    private fun initViews() {
        with(binding) {
            rvFeed.adapter = rssItemAdapter
            rvFeed.layoutManager = LinearLayoutManager(
                this@MainActivity,
                RecyclerView.VERTICAL,
                false
            )
            btnLoadFeed.setOnClickListener {
                viewModel.loadData()
            }
            btnClearFeed.setOnClickListener {
                viewModel.clearData()
            }
        }
    }
}