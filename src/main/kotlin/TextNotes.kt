interface TextNotes<T> {
    fun add(entity: T): Long
    fun delete(id: Long)
    fun edit(entity: T)
    fun read(): List<T>
    fun getById(id: Long): T
    fun restore(id: Long)
}