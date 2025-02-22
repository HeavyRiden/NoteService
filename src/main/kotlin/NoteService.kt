class NoteService(
    private var listOfNotes: MutableList<Note> = mutableListOf(),
    private var idNextNote: Int = 1

) {
    fun add(entity: Note): Int {
        listOfNotes += entity
        entity.id = idNextNote
        idNextNote += 1
        return idNextNote
    }

    fun delete(id: Int) {
        if (listOfNotes.size >= id) {
            listOfNotes.removeAt((id - 1).toInt())
            idNextNote -= 1
        } else println("Такого индекса заметки нет!")

    }

    fun edit(entity: Note) {
        if(listOfNotes.size > entity.id) listOfNotes[entity.id - 1] = entity
        else println("Такого индекса заметки нет!")
    }

    fun read(): List<Note> {
        return listOfNotes
    }

    fun getById(id: Long): Note {
        return listOfNotes[(id - 1).toInt()]
    }

    fun restore(id: Long) {
        TODO("Not yet implemented")
    }
}