data class Comment(
    val noteId: Long, // Идентификатор заметки
    val message: String, // Текст комментария
    val guId: Long, // Уникальный идентификатор комментария
    val visible: Boolean // Видимость комментария и возможность редактирования
)
