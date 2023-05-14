package tech.ericwathome.todo.feature_note.presentation.all_notes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import tech.ericwathome.todo.R
import tech.ericwathome.todo.feature_note.domain.use_case.NoteUseCases
import tech.ericwathome.todo.util.UiEvent
import tech.ericwathome.todo.util.UiText
import javax.inject.Inject

@HiltViewModel
class AllNotesViewModel @Inject constructor(
    private val useCases: NoteUseCases
) : ViewModel() {

    var state by mutableStateOf(AllNotesState())
        private set

    private var _event = Channel<UiEvent>()
    val event = _event.receiveAsFlow()

    fun onEvent(event: AllNotesEvent) {
        when (event) {
            is AllNotesEvent.OnClickNote -> {
                viewModelScope.launch {
                    state = state.copy(
                        selectedNoteId = event.id
                    )
                    _event.send(UiEvent.Success(event.id))
                }
            }
            is AllNotesEvent.OnClickAddNote -> {
                viewModelScope.launch {
                    _event.send(UiEvent.Success())
                }
            }

            is AllNotesEvent.OnClickDeleteNote -> {
                viewModelScope.launch {
                    useCases.deleteNote(event.note)
                    _event.send(UiEvent.ShowSnackBar(UiText.StringResource(R.string.deleted_successfully)))
                }
            }
        }
    }

}