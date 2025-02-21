class NoteService(
    private var listOfNotes: MutableList<Note> = mutableListOf(), // Список заметок
    private var idNextNote: Int = 1 // Начальный индекс заметки

) : TextNotes<Note> {
    override fun add(entity: Note): Int { // Добавление заметки
        listOfNotes += entity
        entity.id = idNextNote
        idNextNote += 1
        return idNextNote
    }

    fun createComment(id: Int, comment: Comment) { // Добавление комментария к заметке
        if (listOfNotes.size >= id) {
            listOfNotes[id - 1].listOfComments += comment
        } else println("Такого индекса заметки нет!")
    }

    override fun delete(id: Int) { // Удаление заметки
        if (listOfNotes.size >= id) {
            listOfNotes.removeAt(id - 1)
            idNextNote -= 1
        } else println("Такого индекса заметки нет!")

    }

    fun deleteComment(id: Int, comId: Int) { // Удаление комментария к заметке
        if (listOfNotes.size >= id) {
            if (listOfNotes[id].listOfComments.size > comId)
                listOfNotes[id].listOfComments[id].visible = false
        } else println("Такого индекса заметки нет!")
    }

    override fun edit(entity: Note) {
        if (listOfNotes.size >= entity.id) listOfNotes[entity.id - 1] = entity
        else println("Такого индекса заметки нет!")
    }

    override fun read(): List<Note> {
        return listOfNotes
    }

    override fun getById(id: Int): Note {
        if (listOfNotes.size >= id) return listOfNotes[id - 1]
        else throw IndexOutOfBoundsException("Такого индекса заметки нет!")
    }

    override fun restore(id: Int) {
        TODO("Not yet implemented")
    }
}