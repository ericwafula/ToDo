package tech.ericwathome.todo.feature_note.domain.repository

import kotlinx.coroutines.flow.Flow
import tech.ericwathome.todo.feature_note.data.entity.NoteEntity
import tech.ericwathome.todo.feature_note.domain.model.Note

interface NoteRepository {
    fun getAllNotes(): Flow<List<Note>>

    fun findNote(id: Long): Flow<Note>

    suspend fun addNote(noteEntity: Note)

    suspend fun updateNote(noteEntity: Note)

    suspend fun deleteNote(noteEntity: Note)
}