package com.example.noteapp.data

import com.example.noteapp.model.Note

class NoteData {
    fun loadNoteData():List<Note>{
        return listOf(
            Note(title = "Today's tasks", description = "i have to work on jetpakc" +
                    "i have to download slaudin Ayubi" +
                    "i have to upgrade android studio"),
            Note(title = "Programming concepts", description = "python data structures" +
                    "file handling in python and c" +
                    "string functions in c and python"),
            Note(title = "Time Table", description = "university at seven pm" +
                    "class at Nicon institute" +
                    "back to home at five"),
            Note(title = "Today's tasks", description = "i have to work on jetpakc" +
                    "i have to download kurlus osman" +
                    "i have to upgrade android studio")
        )
    }
}