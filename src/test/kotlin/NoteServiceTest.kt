import org.junit.Assert.*
import org.junit.Test

class NoteServiceTest {

    private val testNote = Note(title = "Заголовок", text = "Заметка")
    private val testNote2 = Note(title = "Заголовок2", text = "Заметка2")
    private val comment = Comment(1, 1, "Комментарий")
    private val comment2 = Comment(1, 1, "Комментарий 2")
    private val service = NoteService()

    @Test
    fun addNote() {

        assertEquals(service.addNote(testNote), 2)
    }

    @Test
    fun addCommTrue() {
        service.addNote(testNote)

        assertTrue(service.addComment(1, comment))
    }

    @Test
    fun addCommFalse() {

        assertFalse(service.addComment(1, comment))
    }

    @Test
    fun delNoteTrue() {
        service.addNote(testNote)

        assertTrue(service.deleteNote(1))
    }

    @Test
    fun delNoteFalse() {

        assertFalse(service.deleteNote(1))
    }

    @Test
    fun delCommTrue() {
        service.addNote(testNote)
        service.addComment(1, comment)

        assertTrue(service.deleteComment(1, 11))
    }

    @Test
    fun delCommFalse() {

        assertFalse(service.deleteComment(1, 11))
    }

    @Test
    fun editNoteTrue() {
        service.addNote(testNote)

        assertTrue(service.editNote(1, testNote2))
    }

    @Test
    fun editNoteFalse() {

        assertFalse(service.editNote(1, testNote2))
    }

    @Test
    fun editCommTrue() {
        service.addNote(testNote)
        service.addComment(1, comment)

        assertTrue(service.editComment(1, 11, comment2))
    }

    @Test
    fun editCommFalse() {
        service.addNote(testNote)
        service.addComment(1, comment)

        assertFalse(service.editComment(1, 12, comment2))
    }

    @Test
    fun readCommTrue() {
        service.addNote(testNote)
        service.addComment(1, comment)

        assertTrue(service.readComment(1))
    }

    @Test
    fun readCommFalse() {
        service.addNote(testNote)
        service.addComment(1, comment)

        assertFalse(service.readComment(2))
    }

    @Test
    fun getByIdTrue() {
        service.addNote(testNote)
        service.addNote(testNote2)

        assertTrue(service.getByIdNote(2))
    }

    @Test
    fun getByIdFalse() {
        service.addNote(testNote)
        service.addNote(testNote2)

        assertFalse(service.getByIdNote(6))
    }

    @Test
    fun restoreCommTrue() {
        service.addNote(testNote)
        service.addComment(1, comment)
        service.deleteComment(1, 11)

        assertTrue(service.restoreComment(1, 11))
    }

    @Test
    fun restoreCommFalse() {
        service.addNote(testNote)
        service.addComment(1, comment)
        service.deleteComment(1, 11)

        assertFalse(service.restoreComment(1, 12))
    }

}