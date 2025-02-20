class Note (
    var title: String, // Заголовок заметки
    var text: String, // Тест заметки

) : TextNotes<Note> {
    override fun add(entity: Note): Long {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }

    override fun edit(entity: Note) {
        TODO("Not yet implemented")
    }

    override fun read(): List<Note> {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long): Note {
        TODO("Not yet implemented")
    }

    override fun restore(id: Long) {
        TODO("Not yet implemented")
    }
}