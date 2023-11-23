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
}