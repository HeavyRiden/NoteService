fun main() {

    val note = Note( title = "Заголовок", text = "Заметка", listOfComments = null)
    val note2 = Note(1, "Заголовок2", "Заметка2", null)
    val note3 = Note(5, "Заголовок3", "Заметка3", null)
    val comm1 = Comment(1, 1, "Комментарий")
    val comm2 = Comment(1, 2, "Комментарий2")

    val serv = NoteService()
    serv.add(note2)
    serv.add(note)
    serv.edit(note3)
    println(serv.read())
}