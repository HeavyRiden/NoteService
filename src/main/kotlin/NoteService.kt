import java.lang.IndexOutOfBoundsException

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

    fun createComment(id: Long, comment: Comment){
        if (listOfNotes.size >= id) {
            listOfNotes.get(id.toInt() - 1).listOfComments += comment
        } else println("Такого индекса заметки нет!")
    }
    override fun delete(id: Long) {
        if (listOfNotes.size >= id) {
            listOfNotes.removeAt((id - 1).toInt())
            idNextNote -= 1
        } else println("Такого индекса заметки нет!")

    }

    fun deleteComment(id: Long, comId: Long){
        if (listOfNotes.size >= id) {
            listOfNotes.removeAt((id - 1).toInt())
            idNextNote -= 1
        } else println("Такого индекса заметки нет!")
    }

    override fun edit(entity: Note) {
        if(listOfNotes.size >= entity.id) listOfNotes[(entity.id - 1).toInt()] = entity
        else println("Такого индекса заметки нет!")
    }

    override fun read(): List<Note> {
        return listOfNotes
    }

    override fun getById(id: Long): Note {
        if(listOfNotes.size >= id) return listOfNotes[(id - 1).toInt()]
        else throw IndexOutOfBoundsException("Такого индекса заметки нет!")
    }

    override fun restore(id: Long) {
        TODO("Not yet implemented")
    }
}