class NoteService(
    private var listOfNotes: MutableList<Note> = mutableListOf(),
    private var idNote: Int = 1,

    ) {
    fun addNote(entity: Note): Int {
        listOfNotes += entity
        entity.id = idNote
        idNote += 1
        return idNote
    }

    fun addComment(noteId: Int, comment: Comment): Boolean {
        for (i in listOfNotes.indices) {
            if (listOfNotes[i].id == noteId) {
                listOfNotes[i].listOfComments += comment
                comment.commId = listOfNotes[i].id * 10 + listOfNotes[i].listOfComments.size
                return true
            }
        }
        println("Неверный ввод параметров")
        return false
    }

    fun deleteNote(idNote: Int): Boolean {
        for (i in listOfNotes.indices) {
            if (listOfNotes[i].id == idNote) {
                listOfNotes.removeAt(i)
                return true
            }
        }
        println("Неверный ввод параметров")
        return false
    }

    fun deleteComment(noteId: Int, comId: Int): Boolean {
        for (i in listOfNotes.indices) {
            if (listOfNotes[i].id == noteId) {
                for (k in listOfNotes[i].listOfComments.indices) {
                    if (listOfNotes[i].listOfComments[k].commId == comId) {
                        listOfNotes[i].listOfComments[k].visible = false
                        return true
                    }
                }
            }
        }
        println("Неверный ввод параметров")
        return false
    }

    fun editNote(noteId: Int, entity: Note): Boolean {
        for (i in listOfNotes.indices) {
            if (listOfNotes[i].id == noteId) {
                listOfNotes[i] = entity
                return true
            }
        }
        println("Неверный ввод параметров")
        return false
    }

    fun editComment(noteId: Int, comId: Int, comment: Comment): Boolean {
        for (i in listOfNotes.indices) {
            if (listOfNotes[i].id == noteId) {
                for (k in listOfNotes[i].listOfComments.indices) {
                    if (listOfNotes[i].listOfComments[k].commId == comId &&
                        listOfNotes[i].listOfComments[k].visible
                    ) {
                        listOfNotes[i].listOfComments[k].message = comment.message
                        return true
                    }
                }
            }
        }
        println("Неверный ввод параметров")
        return false
    }

    fun readNote() {
        println(listOfNotes)
    }

    fun readComment(noteId: Int): Boolean {
        for (i in listOfNotes.indices) {
            if (listOfNotes[i].id == noteId) {
                println(listOfNotes[i].listOfComments)
                return true
            }
        }
        println("Неверный ввод параметров")
        return false
    }

    fun getByIdNote(noteId: Int): Boolean {
        for (i in listOfNotes.indices) {
            if (listOfNotes[i].id == noteId) {
                println(listOfNotes[i])
                return true
            }
        }
        return false
    }

    fun restoreComment(noteId: Int, comId: Int): Boolean {
        for (i in listOfNotes.indices) {
            if (listOfNotes[i].id == noteId) {
                for (k in listOfNotes[i].listOfComments.indices) {
                    if (listOfNotes[i].listOfComments[k].commId == comId) {
                        listOfNotes[i].listOfComments[k].visible = true
                        return true
                    }
                }
            }
        }
        println("Неверный ввод параметров")
        return false
    }
}
