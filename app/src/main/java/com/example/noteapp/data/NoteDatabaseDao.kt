package com.example.noteapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.noteapp.model.Note
import kotlinx.coroutines.flow.Flow

/* Creating DAO
* Dao is actually something that has the direct access to the database
* and can perform all the DB functions
*
* one thing to notice, each of these data base queries may take a long in case of huge data.
* in this case, user will keep on waiting and that's disgusting
* so in order to handle this situation, we may want to suspend these functions and run other functions
* once the query results are available, we can come back and grab the results
*
*
*  */
@Dao
interface NoteDatabaseDao {
//    fun getNotes():List<Note>
//    and in order to achieve the asynchronicity and avoid ui threat for getNotes,
//    we wrap up the list of Notes inside a Flow(coroutine)
//    works perfectly when working with room data base
    @Query("select * from notes_table")
    fun getNotes():Flow<List<Note>>

    @Query("select * from notes_table where id=:id")
    suspend fun getNoteById(id:String):Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note:Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note:Note)

    @Query("Delete from notes_table")
   suspend fun deleteAll()

    @Delete
    suspend fun deleteNote(note:Note)
}
