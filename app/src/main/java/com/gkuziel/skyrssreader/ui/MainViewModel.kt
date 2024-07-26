package com.gkuziel.skyrssreader.ui


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gkuziel.skyrssreader.model.RssItem

class MainViewModel internal constructor(
    // repository
) : ViewModel() {
    private val initialViewState = emptyList<RssItem>()

    private val _state = MutableLiveData(initialViewState)

    val state: LiveData<List<RssItem>>
        get() = _state
}


