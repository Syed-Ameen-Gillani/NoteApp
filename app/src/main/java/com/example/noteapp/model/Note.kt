package com.example.noteapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID
/*
* perform these steps after setting up the room database and actually creating the room data base
* 1--> you know, we have tables in data base, so each of our note will become a table in database, for that
* 2--> add this annotation before the data class that should appear as a table in the database
*       2.1 --> @Entity(tableName = "notes_table")
* 3--> now add the primary key for your table, in this case we have noteId as a primary key
*       3.1--> add this annotation before your column @PrimaryKey
* 4--> now for rest of the attributes that are going to be the columns of your table, add this annotation before
* all of them
*       4.1 --> @ColumnInfo("column_name")
* */
@Entity(tableName = "notes_table")
data class Note(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

    @ColumnInfo("note_title")
    val title:String,

    @ColumnInfo("note_description")
    val description:String,

    @ColumnInfo("Entry_time")
    val date: Date = Date.from(Instant.now()))
