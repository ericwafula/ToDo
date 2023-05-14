package tech.ericwathome.todo.feature_note.presentation.all_notes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import tech.ericwathome.todo.R
import tech.ericwathome.todo.feature_note.domain.use_case.AddNote
import tech.ericwathome.todo.feature_note.presentation.all_notes.components.NoteItem
import tech.ericwathome.todo.ui.theme.ToDoTheme
import tech.ericwathome.todo.util.UiEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllNotesScreen(
    modifier: Modifier = Modifier,
    onClickAddNote: () -> Unit,
    onClickNote: (Long) -> Unit
) {
    val viewModel: AllNotesViewModel = hiltViewModel()

    LaunchedEffect(key1 = true) {
        viewModel.event.collect { event ->
            when(event) {
                is UiEvent.ShowSnackBar -> {

                }
                is UiEvent.Success -> {
                    if(event.id != null) {
                        onClickNote(event.id)
                    } else {
                        onClickAddNote()
                    }
                }
                else -> Unit
            }
        }
    }

    Scaffold(
        floatingActionButton = {
            Button(onClick = { viewModel.onEvent(AllNotesEvent.OnClickAddNote) }) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_add),
                    contentDescription = null
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentPadding = PaddingValues(12.dp)
        ) {
            items(viewModel.state.notes) { note ->
                NoteItem(
                    note = note,
                    onClick = { viewModel.onEvent(AllNotesEvent.OnClickNote(it)) },
                    onClickDelete = { viewModel.onEvent(AllNotesEvent.OnClickDeleteNote(note)) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AllNotesScreenPreview() {
    ToDoTheme {
        AllNotesScreen(
            onClickNote = { },
            onClickAddNote = { }
        )
    }
}