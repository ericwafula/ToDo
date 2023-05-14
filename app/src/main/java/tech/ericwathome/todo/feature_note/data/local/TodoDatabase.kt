package tech.ericwathome.todo.feature_note.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import tech.ericwathome.todo.feature_note.data.entity.NoteEntity

@Database(
    entities = [NoteEntity::class],
    version = 1
)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}