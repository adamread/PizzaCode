package dev.adamread.pizzacoda

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import dev.adamread.pizzacoda.ui.theme.PizzaCodaTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      PizzaCodaTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          Content(name = stringResource(R.string.greeting_name))
        }
      }
    }
  }
}

@Composable
fun Content(name: String, modifier: Modifier = Modifier) {

  var showPressDialog by rememberSaveable { mutableStateOf(false) }

  if (showPressDialog) {
    PressDialog (
      onDismissRequest = {
        showPressDialog = false
      }
    )
  }

  Column (modifier = modifier,
          horizontalAlignment = Alignment.CenterHorizontally) {
    Row (
      verticalAlignment = Alignment.CenterVertically
    ){
      Text(
        text = "Hello $name",
        style = MaterialTheme.typography.headlineMedium)
    }
    Row (
      verticalAlignment = Alignment.CenterVertically
    ){
      Button(
        modifier = modifier,
        onClick = {
                  showPressDialog = true
        },
      ) {
        Text(text = stringResource(R.string.button_text))
      }
    }
  }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  PizzaCodaTheme {
    Content("Android")
  }
}