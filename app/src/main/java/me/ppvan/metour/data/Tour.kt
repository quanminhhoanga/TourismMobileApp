package me.ppvan.metour.data

import java.time.LocalDateTime

data class Tour constructor(
    val title: String,
    val place: String,
    val imageURL: String,
    val beginTime: LocalDateTime
) {
    companion object {
        val DEFAULT = Tour(
            title = "Di tích nhà tù Hỏa Lò",
            place = "Trần Hưng Đạo, Hoàn Kiếm",
            imageURL = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/00/Ho%E1%BA%A3_L%C3%B2.jpg/320px-Ho%E1%BA%A3_L%C3%B2.jpg",
            beginTime = LocalDateTime.now()
        )
    }
}

data class Tourism(
    val id: Int,
    val name: String,
    val location: String,
    val rate: String,
    val description: String,
    val ticketPrice: String,
    val picture: Int,
    val schedule: List<Schedule>,
    val isFavorite: Boolean
)

data class Schedule(
    val id: Int,
    val day: String,
    val date: String,
    val isAvailable: Boolean,
    var isSelected: Boolean
)