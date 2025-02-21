data class Comment(
    val noteId: Int, // Идентификатор заметки
    val guId: Int, // Уникальный идентификатор комментария
    val message: String // Текст комментария
) {
    var visible: Boolean = true // Видимость комментария и возможность редактирования

    override fun toString(): String {
        return "Комментарий к заметке $noteId -  $message"
    }
}
