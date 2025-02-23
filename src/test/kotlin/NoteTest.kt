import org.junit.Assert.*
import org.junit.Test

class NoteTest {

    val note = Note(title = "Заголовок", text = "Заметка")
    val serv = NoteService()

    @Test
    fun addNote() {

        val result = serv.addNote(note)

        assertEquals(result, 1)
    }


}