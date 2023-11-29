package me.ppvan.metour.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import me.ppvan.metour.data.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE userId IN (:userIds)")
    fun loadAllByIds(userIds: LongArray): List<User>

    @Query("SELECT * FROM user WHERE fullName LIKE :fullName LIMIT 1")
    fun findByName(fullName: String): User

    @Query("SELECT * FROM user WHERE email = :email AND password = :password")
    fun findByEmailAndPassword(email: String, password: String): User?

    @Insert
    fun insert(user: User)

    @Delete
    fun delete(user: User)
}
