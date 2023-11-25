package me.ppvan.metour.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import me.ppvan.metour.data.User
import me.ppvan.metour.repository.AuthService

class ProfileViewModel constructor(authService: AuthService) : ViewModel() {

    val editMode = mutableStateOf(false)
    val loggedInUser = mutableStateOf(User.default())

    fun navigateToEditMode() {
        editMode.value = true
    }

    fun navigateToViewMode() {
        editMode.value = false
    }

    fun updateUserProfile(user: User) {
        Log.d("ProfileViewModel", user.toString())
    }
}