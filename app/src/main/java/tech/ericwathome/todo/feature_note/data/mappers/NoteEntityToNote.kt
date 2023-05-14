package tech.ericwathome.todo.feature_note.data.mappers

import tech.ericwathome.todo.feature_note.data.entity.NoteEntity
import tech.ericwathome.todo.feature_note.domain.model.Note

fun NoteEntity.toNote(): Note {
    return Note(
        id = id,
        title = title,
        description = description
    )
}