data class Note(
    var id: Long = 0, // Идентификатор заметки
    var title: String, // Заголовок заметки
    var text: String, // Тест заметки
    var listOfComments: MutableList<Comment> = mutableListOf() // список комментариев к заметке
)