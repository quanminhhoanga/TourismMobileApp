package me.ppvan.metour.repository

import me.ppvan.metour.data.Tourism

interface TourismRepository {
    suspend fun findRecommendations(): List<Tourism>
    suspend fun findPopulars(): List<Tourism>
    suspend fun findTourByName(name: String): List<Tourism>
}