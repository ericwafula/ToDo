package tech.ericwathome.todo.feature_note.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import tech.ericwathome.todo.feature_note.data.entity.NoteEntity

@Dao
interface NoteDao {

    @Upsert
    suspend fun upsertNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM note_entity ORDER BY title ASC")
    fun allNotes(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM note_entity WHERE id = :id")
    fun getNote(id: Long): Flow<NoteEntity>

    @Delete
    fun deleteNote(noteEntity: NoteEntity)

}