package tech.ericwathome.todo.feature_note.domain.use_case

import tech.ericwathome.todo.feature_note.domain.model.Note
import tech.ericwathome.todo.feature_note.domain.repository.NoteRepository
import javax.inject.Inject

class AddNote @Inject constructor(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) {
        repository.addNote(note)
    }
}