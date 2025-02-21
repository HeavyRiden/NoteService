data class Comment(
    val noteId: Long, // Идентификатор заметки
    val guId: Long, // Уникальный идентификатор комментария
    val message: String // Текст комментария
) {
    var visible: Boolean = true // Видимость комментария и возможность редактирования

    override fun toString(): String {
        return "Комментарий к заметке $noteId -  $message"
    }
}
