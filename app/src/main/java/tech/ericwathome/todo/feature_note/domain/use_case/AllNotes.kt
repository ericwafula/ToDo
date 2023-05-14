package tech.ericwathome.todo.feature_note.domain.use_case

import tech.ericwathome.todo.feature_note.domain.repository.NoteRepository
import javax.inject.Inject

class AllNotes @Inject constructor(
    private val repository: NoteRepository
) {
    operator fun invoke() = repository.getAllNotes()
}