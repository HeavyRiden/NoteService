fun main() {

    val note = Note( title = "Заголовок", text = "Заметка")
    val note2 = Note(1, "Заголовок2", "Заметка2")
    val note3 = Note(1, "Заголовок3", "Заметка3")
    val comm1 = Comment(1, 1, "Комментарий")
    val comm2 = Comment(1, 2, "Комментарий2")

    val serv = NoteService()
    serv.addNote(note2)
    serv.addNote(note)
    serv.addComment(1, comm1)
    serv.addComment(1, comm2)
    serv.deleteComment(1, 11)
    println(serv.readNote())
    serv.restoreComment(1, 11)
    println(serv.readNote())
}