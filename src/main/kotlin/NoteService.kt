class NoteService(
    private var listOfNotes: MutableList<Note> = mutableListOf(),
    private var idNextNote: Int = 1,
    private var idComment: Int = 1

) {
    fun addNote(entity: Note): Int {
        listOfNotes += entity
        entity.id = idNextNote
        idComment = idNextNote * 10 + 1
        idNextNote += 1
        return idNextNote
    }

    fun addComment(noteId: Int, comment: Comment) {
        if (listOfNotes.size >= noteId) {
            comment.commId = idComment
            idComment += 1
            listOfNotes[noteId - 1].listOfComments += comment
        } else {
            println("Заметки с таким индексом нет!")
        }
    }

    fun deleteNote(idNote: Int) {
        if (listOfNotes.size >= idNote) {
            listOfNotes.removeAt(idNote - 1)
            idNextNote -= 1
        } else println("Такого индекса заметки нет!")

    }

    fun deleteComment(noteId: Int, comId: Int) {
        if (listOfNotes.size >= noteId) {
            if (listOfNotes[noteId - 1].listOfComments.size >= comId % 10 - 1 &&
                listOfNotes[noteId - 1].listOfComments[comId % 10 - 1].visible
            ) {
                listOfNotes[noteId - 1].listOfComments[comId % 10 - 1].visible = false
            } else println("Такого индекса комментария нет")
        } else println("Такого индекса заметки нет!")
    }

    fun editNote(noteId: Int, entity: Note) {
        if (listOfNotes.size >= noteId) listOfNotes[entity.id - 1] = entity
        else println("Такого индекса заметки нет!")
    }

    fun editComment(noteId: Int, comId: Int, comment: Comment) {
        if (listOfNotes.size >= noteId) {
            if (listOfNotes[noteId - 1].listOfComments.size >= comId % 10 - 1 &&
                listOfNotes[noteId - 1].listOfComments[comId % 10 - 1].visible
            ) {
                listOfNotes[noteId - 1].listOfComments[comId % 10 - 1] = comment
            } else println("Такого индекса комментария нет")
        } else println("Такого индекса заметки нет!")
    }

    fun readNote() {
        println(listOfNotes)
    }

    fun readComment(noteId: Int) {
        if (listOfNotes.size >= noteId) {
            println(listOfNotes[noteId - 1].listOfComments)
        } else println("Такого индекса заметки нет!")
    }

    fun getByIdNote(noteId: Int) {
        if (listOfNotes.size >= noteId) println(listOfNotes[noteId - 1])
    }

    fun restoreComment(noteId: Int, comId: Int) {
        if (listOfNotes.size >= noteId) {
            if (listOfNotes[noteId - 1].listOfComments.size >= comId % 10 - 1) {
                listOfNotes[noteId - 1].listOfComments[comId % 10 - 1].visible = true
            } else println("Такого индекса комментария нет")
        } else println("Такого индекса заметки нет!")
    }
}