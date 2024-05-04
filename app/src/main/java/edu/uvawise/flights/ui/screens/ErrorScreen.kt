package edu.uvawise.flights.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun ErrorScreen() {
    // TODO stub
    Column(
        modifier = Modifier.fillMaxSize(),
       verticalArrangement = Arrangement.Center
    ) {
        Text(
            "\uD83D\uDCA9",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 48.sp,
            textAlign = TextAlign.Center
        )
    }
}