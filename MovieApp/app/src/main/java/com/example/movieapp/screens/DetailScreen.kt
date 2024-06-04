package com.example.movieapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.AddButton

@Composable
fun DetailScreen(navController: NavController, string: String?) {
    Details(string,navController)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Details(string: String?, navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(
            { 
                Row(horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically){
                    Icon(imageVector = Icons.Default.ArrowBack,
                        modifier = Modifier.clickable { navController.popBackStack() },
                        contentDescription ="" )
                    Spacer(modifier = Modifier.width(80.dp))
                    Text(text = "Movie App", fontWeight = FontWeight.SemiBold)
                }
            },
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
       Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
           Surface(modifier = Modifier.size(200.dp),
               shape = RoundedCornerShape(6.dp),
               color = Color.LightGray,
               contentColor = Color.Black,
               shadowElevation = 10.dp){
                Box(contentAlignment = Alignment.Center){
                    Text(text = string?:"",
                        fontWeight = FontWeight.Black,
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
           }
       }
    }
}