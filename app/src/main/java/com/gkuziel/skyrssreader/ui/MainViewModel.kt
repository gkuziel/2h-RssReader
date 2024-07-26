package com.gkuziel.skyrssreader.ui


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gkuziel.skyrssreader.data.Repository
import com.gkuziel.skyrssreader.model.RssItem
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel internal constructor(
    private val repository: Repository = Repository()
) : ViewModel() {

    private val initialViewState = emptyList<RssItem>()
    private val _state = MutableLiveData(initialViewState)

    val state: LiveData<List<RssItem>>
        get() = _state


    fun clearData() {
        _state.value = emptyList()
    }

    fun loadData(): Job {
        return viewModelScope.launch {
            try {
                val feed = repository.loadRssWorlds()
                _state.value = listOf(RssItem(feed))
            } catch (error: Throwable) {
                //
            } finally {
                //
            }
        }
    }
}


