package tech.ericwathome.todo.feature_note.presentation.all_notes

import tech.ericwathome.todo.feature_note.domain.model.Note

data class AllNotesState(
    var notes: List<Note> = emptyList(),
    var selectedNoteId: Long? = null
)
