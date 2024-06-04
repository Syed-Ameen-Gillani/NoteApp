package com.example.noteapp.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteapp.components.noteButton
import com.example.noteapp.components.noteInputText
import com.example.noteapp.components.noteRow
import com.example.noteapp.data.NoteData
import com.example.noteapp.model.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    notes: List<Note>,
    onAddNote: (Note)->Unit,
    onRemoveNote:(Note)->Unit
) {
    var title by remember{
        mutableStateOf("")
    }
    var description by remember{
        mutableStateOf("")
    }
    val context = LocalContext.current
    Column(modifier = Modifier.padding(6.dp)){
        TopAppBar(title = {
            Text(text = "NoteApp")
        },
            actions = {
                Icon(imageVector = Icons.Rounded.Notifications, contentDescription ="none" )
            },
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
            ,modifier = Modifier
                .fillMaxWidth()){
            noteInputText(text = title, label = "Title", onTextChange = {
                title = it
            })
            noteInputText(text = description, label = "Add a note", onTextChange = {
                description = it
            })
            noteButton(text = "click", onClick = {
                    if (description.isNotEmpty() && title.isNotEmpty()){
                        onAddNote(Note(title = title, description = description))
                        Toast.makeText(context, "Note Added",Toast.LENGTH_SHORT)
                        title  = ""
                        description =""
                    }
            })
            Divider(modifier = Modifier.
            padding(5.dp))
            LazyColumn{
                items(notes){ it ->
                    noteRow(note = it, onRemoveNote = {onRemoveNote(it)})
                }
            }
        }

    }

}
