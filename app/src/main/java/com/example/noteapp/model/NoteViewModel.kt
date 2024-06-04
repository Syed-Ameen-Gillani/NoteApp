package com.example.noteapp.model

import android.util.Log

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.noteapp.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private  val repository: NoteRepository) :ViewModel() {
    //    private var noteList = mutableStateListOf<Note>()
    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

    //    init {
//        noteList.addAll(NoteData().loadNoteData())
//    }
    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes().distinctUntilChanged()
                .collect { notes ->
                    withContext(Dispatchers.Main) {
                        _noteList.value = notes
                    }
                }
        }
    }

    fun addNote(note: Note) = viewModelScope.launch { repository.addNote(note) }

    //    fun removeNote(note: Note){
//        noteList.remove(note)
//    }
    fun removeNote(note: Note) = viewModelScope.launch { repository.deleteNote(note) }

    //    fun getAllNotes():List<Note>{
//        return  noteList
//    }
    fun updateNote(note: Note) = viewModelScope.launch { repository.updateNote(note) }
}
//    fun addNote(note: Note){
//        noteList.add(note)
//    }
