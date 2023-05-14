package tech.ericwathome.todo.util

sealed class UiText {
    data class DynamicString(val string: String) : UiText()
    data class StringResource(val id: Int) : UiText()
}
