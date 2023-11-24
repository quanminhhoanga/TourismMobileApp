package me.ppvan.metour.repository

import kotlinx.coroutines.delay
import me.ppvan.metour.data.FakeTourismDataSource
import me.ppvan.metour.data.Tourism

class RoomTourismRepository : TourismRepository {
    override suspend fun findRecommendations(): List<Tourism> {
        delay(1000)
        return FakeTourismDataSource.dummyTourism
    }

    override suspend fun findPopulars(): List<Tourism> {
        delay(1000)
        return FakeTourismDataSource.dummyTourism
    }

    override suspend fun findTourByName(name: String): List<Tourism> {
        delay(1000)
        if (name.isBlank()) {
            return emptyList()
        }
        return FakeTourismDataSource.dummyTourism.filter { tour -> tour.name.contains(name) }
    }

    override suspend fun updateFavoriteTourism(id: Int) {
        val tourism = findTourismById(id)
        tourism.isFavorite = !tourism.isFavorite
    }

    override suspend fun findTourismById(id: Int): Tourism {
        return FakeTourismDataSource.dummyTourism.find { tourism -> tourism.id == id }
            ?: Tourism.default()
    }
}