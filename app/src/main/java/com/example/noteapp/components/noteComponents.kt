package com.example.noteapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noteapp.model.Note
import com.example.noteapp.utils.formatDate

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun noteInputText(
    modifier:Modifier = Modifier,
    text: String,
    label: String,
    maxLine:Int = 1,
    onTextChange:(String)->Unit,
    onImeAction:() -> Unit = {}
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(value = text,
        onValueChange = onTextChange,
        maxLines = maxLine,
        label = { Text(text = label)},
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            keyboardController?.hide()
        }),
        modifier = Modifier
    )
}

@Composable
fun noteButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick:()-> Unit,
    enabled:Boolean = true,
) {

    Button(onClick = onClick,
        modifier = modifier,
        enabled =  enabled,
        shape = CircleShape
        ) {
        Text(text = text)
    }

}

@Composable
fun noteRow(
    modifier:Modifier = Modifier,
    note:Note,
    onRemoveNote:(Note)->Unit
) {
    Surface(modifier = modifier
        .padding(10.dp)
        .clip(shape = RoundedCornerShape(topEnd = 33.dp, bottomStart = 10.dp))
        .fillMaxWidth(),
        tonalElevation = 40.dp
        , color = Color.LightGray
        ){
        Column(modifier = Modifier.padding(11.dp)
            ){
            Text(text = note.title, fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Text(text = note.description)
            Row(horizontalArrangement = Arrangement.End,
                modifier = modifier.fillMaxWidth().padding(top = 12.dp)){
                Text(text = formatDate(note.date.time),
                    fontStyle = FontStyle.Italic,
                    modifier = modifier.padding(top = 3.dp)
                )
                Icon(imageVector = Icons.Filled.Delete,contentDescription = "delete",
                    modifier = modifier
                        .clickable { onRemoveNote(note) }
                        .size(27.dp)

                )
            }

        }
    }
}



