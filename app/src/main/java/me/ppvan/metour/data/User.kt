package me.ppvan.metour.data

data class User(
    val username: String,
    val avatarUrl: String,
    val fullName: String,
    val email: String,
    val phoneNumber: String,
    val city: String
) {
    companion object {
        fun default(): User {
            return User(
                username = "ppvan",
                avatarUrl = "",
                fullName = "Phạm Văn Phúc",
                email = "phuclaplace@gmail.com",
                phoneNumber = "098123456789",
                city = "Hà Nội"
            )
        }
    }
}
