package me.ppvan.metour.repository

interface AuthService {
    fun register(username: String, email: String, phone: String, password: String)
    fun login(email: String, password: String): String
    fun logout(): Boolean
}