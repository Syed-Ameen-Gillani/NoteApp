package com.example.movieapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.AddButton
import com.example.movieapp.card
import com.example.movieapp.navigation.MovieScreens
import com.example.movieapp.navigation.getMovieList

@Composable
fun HomeScreen(navController: NavController) {
    TopSection(navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TopSection(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Movie App", fontWeight = FontWeight.SemiBold) },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Black,
                titleContentColor = Color.White
            )
        )
    },
        contentColor = Color.White,
        floatingActionButton = {
            AddButton()
        }
    ){
        MainContent(navController)
    }
}


@Composable
fun MainContent(navController: NavController) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(20.dp), modifier = Modifier.padding(0.dp,70.dp)){
        items(items = getMovieList()){
            card(it.title, it.image,it.description,it.year,it.producer){
                navController.navigate(MovieScreens.DetailScreen.name+"/${it.title}")
            }
        }
    }
}