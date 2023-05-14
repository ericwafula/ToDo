package tech.ericwathome.todo.feature_note.domain.use_case

data class NoteUseCases(
    val addNote: AddNote,
    val allNotes: AllNotes,
    val deleteNote: DeleteNote,
    val findNote: FindNote,
    val updateNote: UpdateNote
)
