class NoteService(
    private var listOfNotes: MutableList<Note> = mutableListOf(),
    private var idNextNote: Long = 1

) : TextNotes<Note> {
    override fun add(entity: Note): Long {
        listOfNotes += entity
        entity.id = idNextNote
        idNextNote += 1
        return idNextNote
    }

    override fun delete(id: Long) {
        if (listOfNotes.size >= id) {
            listOfNotes.removeAt((id - 1).toInt())
            idNextNote -= 1
        } else println("Такого индекса заметки нет!")

    }

    override fun edit(entity: Note) {
        if(listOfNotes.size > entity.id) listOfNotes[(entity.id - 1).toInt()] = entity
        else println("Такого индекса заметки нет!")
    }

    override fun read(): List<Note> {
        return listOfNotes
    }

    override fun getById(id: Long): Note {
        return listOfNotes[(id - 1).toInt()]
    }

    override fun restore(id: Long) {
        TODO("Not yet implemented")
    }
}