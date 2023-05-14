package tech.ericwathome.todo.feature_note.domain.use_case

import tech.ericwathome.todo.feature_note.domain.repository.NoteRepository
import javax.inject.Inject

class FindNote @Inject constructor(
    private val repository: NoteRepository
) {
    operator fun invoke(id: Long) = repository.findNote(id)
}