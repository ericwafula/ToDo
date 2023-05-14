package tech.ericwathome.todo.feature_note.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import tech.ericwathome.todo.feature_note.data.local.NoteDao
import tech.ericwathome.todo.feature_note.data.mappers.toNote
import tech.ericwathome.todo.feature_note.data.mappers.toNoteEntity
import tech.ericwathome.todo.feature_note.domain.model.Note
import tech.ericwathome.todo.feature_note.domain.repository.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
) : NoteRepository {
    override fun getAllNotes(): Flow<List<Note>> {
        return noteDao.allNotes().map { noteEntityList ->
            noteEntityList.map { noteEntity ->
                noteEntity.toNote()
            }
        }
    }

    override fun findNote(id: Long): Flow<Note> {
       return noteDao.getNote(id).map { it.toNote() }
    }

    override suspend fun addNote(note: Note) {
        noteDao.upsertNote(note.toNoteEntity())
    }

    override suspend fun updateNote(note: Note) {
        noteDao.upsertNote(note.toNoteEntity())
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note.toNoteEntity())
    }
}