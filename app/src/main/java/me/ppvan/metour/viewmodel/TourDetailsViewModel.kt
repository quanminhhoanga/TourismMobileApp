package me.ppvan.metour.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import me.ppvan.metour.data.Schedule
import me.ppvan.metour.data.Tourism
import me.ppvan.metour.repository.TourismRepository

class TourDetailsViewModel constructor(private val repository: TourismRepository) : ViewModel() {
    val favorite = mutableStateOf(false)
    val subcribed = mutableStateOf(false)
    val dialogVisible = mutableStateOf(false)

    private val _listSelectedSchedule = mutableStateListOf<Int>()
    val listSelectedSchedule: List<Int> get() = _listSelectedSchedule

    fun updateFavoriteTourism(id: Int): String {
        viewModelScope.launch {
            val updateResult = repository.updateFavoriteTourism(id)
            isFavoriteTourism(id)
        }

        return ""
    }

    fun updateScheduleTourism(schedule: Schedule) {
        if (listSelectedSchedule.contains(schedule.id)) {
            _listSelectedSchedule.remove(schedule.id)
        } else {
            _listSelectedSchedule.add(schedule.id)
        }
    }

    private fun isFavoriteTourism(id: Int) {
        viewModelScope.launch {
            val result = repository.findTourismById(id)
            favorite.value = result.isFavorite
        }
    }

    fun updateSubscribedState() {
        dialogVisible.value = false
        subcribed.value = !subcribed.value
    }

    suspend fun getDetailById(id: Int): Tourism {
        return withContext(Dispatchers.IO) {
            return@withContext repository.findTourismById(id)
        }
    }

}