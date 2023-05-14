package tech.ericwathome.todo.feature_note.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "note_entity"
)
data class NoteEntity(
    @PrimaryKey var id: Long? = null,
    var title: String,
    var description: String
)
