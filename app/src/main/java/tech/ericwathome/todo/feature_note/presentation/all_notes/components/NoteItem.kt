package tech.ericwathome.todo.feature_note.presentation.all_notes.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tech.ericwathome.todo.R
import tech.ericwathome.todo.feature_note.domain.model.Note
import tech.ericwathome.todo.ui.theme.ToDoTheme

@Composable
fun NoteItem(
    note: Note,
    onClick: (Long) -> Unit,
    onClickDelete: (Note) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 18.dp)
            .clickable { onClick(note.id ?: 0L) },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            val (id, title, description) = note
            Text(text = title)
            Text(text = description)
        }
        IconButton(onClick = { onClickDelete(note) }) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_delete),
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NoteItemPreview() {
    ToDoTheme {
        NoteItem(
            note = Note(
                id = 1,
                title = "Title",
                description = "Note description"
            ),
            onClick = { },
            onClickDelete = { }
        )
    }
}