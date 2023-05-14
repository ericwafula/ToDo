package tech.ericwathome.todo.di

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import tech.ericwathome.todo.feature_note.data.local.NoteDao
import tech.ericwathome.todo.feature_note.data.local.TodoDatabase
import tech.ericwathome.todo.feature_note.data.repository.NoteRepositoryImpl
import tech.ericwathome.todo.feature_note.domain.repository.NoteRepository
import tech.ericwathome.todo.feature_note.domain.use_case.AddNote
import tech.ericwathome.todo.feature_note.domain.use_case.AllNotes
import tech.ericwathome.todo.feature_note.domain.use_case.DeleteNote
import tech.ericwathome.todo.feature_note.domain.use_case.FindNote
import tech.ericwathome.todo.feature_note.domain.use_case.NoteUseCases
import tech.ericwathome.todo.feature_note.domain.use_case.UpdateNote
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideTodoDatabase(@ApplicationContext context: Context): TodoDatabase {
        return Room.databaseBuilder(
            context,
            TodoDatabase::class.java,
            "todo_db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideTodoDao(db: TodoDatabase): NoteDao {
        return db.noteDao()
    }

    @Singleton
    @Provides
    fun provideNoteRepository(dao: NoteDao): NoteRepository {
        return NoteRepositoryImpl(dao)
    }

    @Provides
    fun provideAddNote(repository: NoteRepository): AddNote {
        return AddNote(
            repository = repository
        )
    }

    @Provides
    fun provideAllNotes(repository: NoteRepository): AllNotes {
        return AllNotes(
            repository = repository
        )
    }

    @Provides
    fun provideDeleteNote(repository: NoteRepository): DeleteNote {
        return DeleteNote(
            repository = repository
        )
    }

    @Provides
    fun provideFindNote(repository: NoteRepository): FindNote {
        return FindNote(
            repository = repository
        )
    }

    @Provides
    fun provideUpdateNote(repository: NoteRepository): UpdateNote {
        return UpdateNote(
            repository = repository
        )
    }

    @Provides
    fun provideNoteUseCases(
        addNote: AddNote,
        allNotes: AllNotes,
        deleteNote: DeleteNote,
        findNote: FindNote,
        updateNote: UpdateNote
    ): NoteUseCases {
        return NoteUseCases(
            addNote = addNote,
            allNotes = allNotes,
            deleteNote = deleteNote,
            findNote = findNote,
            updateNote = updateNote
        )
    }

}