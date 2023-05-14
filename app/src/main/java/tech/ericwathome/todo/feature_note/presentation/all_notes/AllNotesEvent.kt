package tech.ericwathome.todo.feature_note.presentation.all_notes

import tech.ericwathome.todo.feature_note.domain.model.Note

sealed class AllNotesEvent {
    data class OnClickNote(val id: Long) : AllNotesEvent()
    object OnClickAddNote : AllNotesEvent()
    data class OnClickDeleteNote(val note: Note) : AllNotesEvent()
}
