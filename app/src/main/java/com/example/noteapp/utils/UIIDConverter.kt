package com.example.noteapp.utils

import androidx.room.TypeConverter
import java.util.UUID

class UUIDConverter {
    @TypeConverter
    fun fromUIID(uuid: UUID) :String?{
        return uuid.toString()
    }

    @TypeConverter
    fun uuidFromString(string: String?):UUID?{
        return UUID.fromString(string)
    }

}