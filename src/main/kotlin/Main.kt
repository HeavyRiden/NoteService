fun main() {

    val note = Note(1, "Заголовок", "Заметка", null)
    val comm1 = Comment(1, 1, "Комментарий")
    val comm2 = Comment(1, 2, "Комментарий2")

    val serv = NoteService()
    println(serv.add(note))
    serv.delete(10)

}