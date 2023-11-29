package me.ppvan.metour.repository

import me.ppvan.metour.data.User

interface AuthService {
    fun register(user: User): Boolean
    fun login(email: String, password: String): User
    fun logout(): Boolean
}