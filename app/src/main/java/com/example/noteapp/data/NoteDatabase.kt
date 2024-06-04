package com.example.noteapp.data

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.noteapp.model.Note
import com.example.noteapp.utils.DateConverter
import com.example.noteapp.utils.UUIDConverter

/*
*creating the skeleton of Database but not the actual database
* create an abstract class with the following notation
* we add the @Database(entities = [list of tables],version = 1, exportSchema = false)
* */
@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class NoteDatabase : RoomDatabase (){
    abstract fun noteDao():NoteDatabaseDao
}
