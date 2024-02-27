package dev.hawari.centang.data

data class Todo(
    val id: Int,
    val title: String,
    val completed: Boolean = false,
    val createdAt: Long = System.currentTimeMillis(),
    val completedAt: Long? = null
)

