package com.example.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.movieapp.navigation.MovieNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieNavigation()
        }
    }
}





@Composable
fun AddButton() {
    FloatingActionButton(
        onClick = {},
        modifier = Modifier.size(70.dp),
        shape = CircleShape,
        containerColor = Color.Black,
        contentColor = Color.White,
        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(
            defaultElevation = 6.dp
        )
    ) {
        Box(contentAlignment = Alignment.Center){
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add button" )
        }
    }
}


@Composable
fun card(
    title:String,
    image: Int,
    description: String,
    year: String,
    producer: String,
    onclick: ()-> Unit
){
    Row(

        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 4.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ){
        Section(title,image,description,year,producer,onclick)
        Section(title,image,description,year,producer,onclick)
    }
}
@Composable
fun Section(
    title: String,
    image: Int,
    description: String ,
    year: String,
    producer: String,
    onclick: () -> Unit
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .clickable { onclick() }
            .width(180.dp),
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 6.dp,
        border = BorderStroke(1.dp, Color.LightGray)

    ) {
        Box(contentAlignment = Alignment.Center) {
            Surface(
                modifier = Modifier
                    .clickable { onclick() }
                    .width(180.dp)
                    .padding(6.dp),
                shape = RoundedCornerShape(3.dp),
                shadowElevation = 10.dp,
                border = BorderStroke(1.dp, Color.LightGray)

            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Image(
                        painter = painterResource(id = image),
                        contentDescription = "m",
                        modifier = Modifier
                            .fillMaxSize()
//                            .fillMaxWidth()
                            .clipToBounds()
                            .padding(3.dp)
                    )
                    Text(text = title,
                        modifier = Modifier
                            .padding(0.dp, 3.dp))
                    Icon(
                        imageVector = if(expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                        contentDescription = "Down",
                        modifier = Modifier.clickable { expanded = !expanded }
                    )
                    AnimatedVisibility(expanded) {

                        Column(horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center){
                            Text(text = description,
                                modifier = Modifier
                                    .padding(0.dp, 3.dp))
                            Text(text = year,
                                modifier = Modifier
                                    .padding(0.dp, 3.dp))
                        }
                    }

                }
            }
        }
    }
}

