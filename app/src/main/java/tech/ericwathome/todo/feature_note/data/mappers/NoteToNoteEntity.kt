package tech.ericwathome.todo.feature_note.data.mappers

import tech.ericwathome.todo.feature_note.data.entity.NoteEntity
import tech.ericwathome.todo.feature_note.domain.model.Note

fun Note.toNoteEntity(): NoteEntity {
    return NoteEntity(
        id = id,
        title = title,
        description = description
    )
}