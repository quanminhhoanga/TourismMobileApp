package me.ppvan.metour.repository

import me.ppvan.metour.dao.UserDao
import me.ppvan.metour.data.User

class RoomAuthService(private val userDao: UserDao) : AuthService {
    override fun register(user: User): Boolean {
        userDao.insert(user)
        // TODO add some validation an fail case
        return true
    }

    override fun login(email: String, password: String): User {
        return userDao.findByEmailAndPassword(email, password) ?: User.default()
    }

    override fun logout(): Boolean {
        return false
    }


}