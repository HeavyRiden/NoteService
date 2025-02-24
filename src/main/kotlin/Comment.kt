data class Comment(
    val noteId: Int, // Идентификатор заметки
    var commId: Int, // Уникальный идентификатор комментария
    var message: String // Текст комментария
) {
    var visible: Boolean = true // Видимость комментария и возможность редактирования

    override fun toString(): String {
        return if(visible) message + commId
        else ""
    }
}
