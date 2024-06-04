package com.example.noteapp.di

import android.content.Context
import androidx.room.Room
import com.example.noteapp.data.NoteDatabase
import com.example.noteapp.data.NoteDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*
* creating instances of dependencies.
* mean creating providers
* binding of dependencies
*  everything is gonna be singleton.
* */
@InstallIn(SingletonComponent::class)
@Module
object AppModule {
@Singleton
@Provides
fun provideNotesDao(noteDatabase: NoteDatabase) :NoteDatabaseDao = noteDatabase.noteDao()



    // now creating the actual database
    // @ApplicationContext this class knows everything about the application
 @Singleton
 @Provides
 fun provideAppDatabase(@ApplicationContext context:Context) : NoteDatabase
 = Room.databaseBuilder(context,NoteDatabase::class.java,"notes_db").fallbackToDestructiveMigration().build()
}


