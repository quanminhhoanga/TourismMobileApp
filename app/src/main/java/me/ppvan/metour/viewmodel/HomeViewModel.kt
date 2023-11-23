package me.ppvan.metour.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import me.ppvan.metour.data.Tourism
import me.ppvan.metour.repository.TourismRepository

enum class HomeStates {
    Loading,
    Done
}

class HomeViewModel(
    private val tourismRepository: TourismRepository
) : ViewModel() {

    val state = mutableStateOf(HomeStates.Loading)
    val recommendations = mutableStateListOf<Tourism>()
    val populars = mutableStateListOf<Tourism>()


    fun loadData() {

    }
}