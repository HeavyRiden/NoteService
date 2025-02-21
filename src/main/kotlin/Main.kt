fun main() {

    val note = Note( title = "Заголовок", text = "Заметка")
    val note2 = Note(1, "Заголовок2", "Заметка2")
    val note3 = Note(1, "Заголовок3", "Заметка3")
    val comm1 = Comment(1, 1, "Комментарий")
    val comm2 = Comment(1, 2, "Комментарий2")

    val serv = NoteService()
    serv.add(note2)
    serv.add(note)
    //serv.edit(note3)
    serv.createComment(1, comm1)
    println(serv.read())
}