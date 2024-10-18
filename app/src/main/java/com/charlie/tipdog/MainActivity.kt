package com.charlie.tipdog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.charlie.tipdog.ui.theme.TipDogTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      TipDogTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize()) {
          SmallTopAppBarExample()
        }
      }
    }
  }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallTopAppBarExample() {
  Scaffold(
    topBar = {
      TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
          containerColor = MaterialTheme.colorScheme.primaryContainer,
          titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
          Text("TipDog")
        }
      )
    },
  ) { innerPadding ->
    Greeting(innerPadding)
  }
}
@Composable
fun Greeting(padding: PaddingValues) {
  var input by remember { mutableStateOf("") }
  val radioOptions = listOf("0.1", "0.15", "0.2")
  val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0] ) }
  Column(modifier = Modifier.padding(top = padding.calculateTopPadding())) {
    Column {
      radioOptions.forEach { text ->
        Row {
          RadioButton(
            selected = (text == selectedOption),
            onClick = { onOptionSelected(text) }
          )
          Text(
            text = text,
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 10.dp)
          )
        }
      }
    }
    Spacer(modifier = Modifier.height(30.dp))
    TextField(
      value = input,
      onValueChange = { input = it },
      keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
      placeholder = { Text("0.00") }
    )

    Spacer(modifier = Modifier.height(30.dp))

    Text(text = calculate(input, selectedOption), fontSize = 36.sp, modifier = Modifier.padding(10.dp))
  }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  TipDogTheme {
    Greeting(PaddingValues(3.dp))
  }
}