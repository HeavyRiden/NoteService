fun main() {

    val note = Note( title = "Заголовок", text = "Заметка")
    val note2 = Note(1, "Заголовок2", "Заметка2")
    val note3 = Note(1, "Заголовок3", "Заметка3")
    val comm1 = Comment(1, 1, "Комментарий1")
    val comm2 = Comment(1, 2, "Комментарий2")

    val serv = NoteService()
    serv.addNote(note)
    serv.addComment(1, comm1)
    serv.addComment(1, comm2)
    serv.editComment(1, 11, comm2)
    serv.deleteComment(1, 11)
    serv.restoreComment(1, 11)
    serv.readComment(1)
    serv.readNote()
}