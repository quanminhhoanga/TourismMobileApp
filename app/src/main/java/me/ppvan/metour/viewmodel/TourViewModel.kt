package me.ppvan.metour.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.ppvan.metour.data.Tourism
import me.ppvan.metour.repository.TourismRepository


enum class TourPageStates {
    Idle, Loading, Done
}

class TourViewModel(val tourismRepository: TourismRepository) : ViewModel() {

    val state = mutableStateOf(TourPageStates.Idle)

    val query = mutableStateOf("")

    val suggestions = mutableStateListOf<Tourism>()
    val results = mutableStateListOf<Tourism>()

    init {
        loadInitialData()
    }

    private fun loadInitialData() {
        if (state.value == TourPageStates.Idle) {
            results.clear()
            viewModelScope.launch(Dispatchers.IO) {
                results.addAll(tourismRepository.findPopulars())
            }

            state.value = TourPageStates.Done
        }
    }

    fun onSearchTour(query: String) {

    }

    fun onSuggesting(query: String) {

    }


}