package dev.adamread.pizzacoda

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun PressDialog(
  onDismissRequest: () -> Unit
) {
  Dialog(onDismissRequest = onDismissRequest) {
    Box(modifier = Modifier.background(Color.Green).size((64.dp)))
  }
}