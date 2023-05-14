package tech.ericwathome.todo.util

sealed class UiEvent {
    data class Success(val id: Long? = null) : UiEvent()
    data class ShowSnackBar(val message: UiText) : UiEvent()
    object NavigateUp : UiEvent()
}
