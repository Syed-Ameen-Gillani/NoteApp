package com.example.moneydistributonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableFloatState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moneydistributonapp.ui.theme.MoneyDistributonAppTheme
import com.example.moneydistributonapp.ui.theme.Pink40
import com.example.moneydistributonapp.ui.theme.Pink80
import com.example.moneydistributonapp.ui.theme.Purple40
import com.example.moneydistributonapp.ui.theme.cardColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoneyDistributonAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun MyApp() {
    var bill = remember {
        mutableStateOf("")
    }
    var moneyPerPerson = remember {
        mutableFloatStateOf(0f)
    }
    Column(Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top){
        section1(moneyPerPerson)
        section2(bill,moneyPerPerson)
    }
}

@Composable
fun section1(moneyPerPerson: MutableFloatState) {

    Card(elevation = CardDefaults.cardElevation(
        defaultElevation = 10.dp,
    ),
        colors = CardDefaults.cardColors(
            containerColor = Pink80
        ),
        modifier = Modifier.padding(20.dp,20.dp,20.dp,5.dp)){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(45.dp)
        ){
            Text(
                text = "Money Per Person",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "$ ${moneyPerPerson.value}",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Black,
                fontSize = 30.sp
            )
        }
    }
}

@Composable
fun section2(bill: MutableState<String>, moneyPerPerson: MutableFloatState) {
    var sliderState = remember {
        mutableFloatStateOf(0f)
    }
    var anotherBill = remember {
        mutableIntStateOf(0)
    }
    var split = remember {
        mutableIntStateOf(1)
    }
    val tipPercentage = remember {
        mutableIntStateOf(0)
    }
    val tip = remember {
        mutableFloatStateOf(0f)
    }
    moneyPerPerson.value = ((tip.value+anotherBill.value)/split.value)
    tip.value = ((tipPercentage.value * anotherBill.value)/100).toFloat()
    tipPercentage.value = (sliderState.value * 100).toInt()
    anotherBill.value = if(bill.value.isNotBlank() && bill.value.toInt()>=1) bill.value.toInt() else 0

    Card(elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp),
        modifier = Modifier
            .padding(10.dp)
            .border(1.dp, Color.LightGray, RoundedCornerShape(10.dp))
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ){
            OutlinedTextField(
                value = "${bill.value}",
                onValueChange = {bill.value = it},
                label = { Text(
                    text = "Enter bill",
                    fontWeight = FontWeight.Bold
                ) },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.fillMaxWidth()
            )
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ){
                Text(text = "Split", Modifier.weight(.5f))
                customButtons(click = {if(split.value!=1) split.value -=1}, text = "-")
                Text(text = "${split.value}")
                customButtons({if(split.value< 10)/*(anotherBill.value+tip.value)/2)*/ split.value +=1},"+")
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ){
                Text(text = "Tip", Modifier.weight(.5f))
                Text(text = "$ ${tip.value}")
            }
            Text(text = " ${tipPercentage.value} %")
            Slider(
                value = sliderState.value,
                onValueChange = { sliderState.value = it},
                colors = SliderDefaults.colors(
                    activeTrackColor = Purple40,
                    inactiveTrackColor = Purple40.copy(alpha = .3f)
                ),
            )
        }
    }
}

@Composable
private fun customButtons(click:()->Unit, text:String) {
    Surface(
        modifier = Modifier
            .size(50.dp)
            .padding(5.dp)
            .clickable { click() },
         shadowElevation = 5.dp,
        shape = CircleShape
    ) {
        Box(contentAlignment = Alignment.Center){
            Text(text = text, style = MaterialTheme.typography.headlineSmall)
        }
    }
}




