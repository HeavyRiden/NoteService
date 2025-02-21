class NoteService(
    private var listOfNotes: MutableList<Note> = mutableListOf(),
    private var idNextNote: Long = 0

) : TextNotes<Note> {
    override fun add(entity: Note): Long {
        listOfNotes += entity
        entity.id = idNextNote
        idNextNote += 1
        return idNextNote
    }

    override fun delete(id: Long) {
        if (listOfNotes.size >= id) listOfNotes.removeAt((id - 1).toInt())
        else println("Такого индекса заметки нет!")
        idNextNote -= 1
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