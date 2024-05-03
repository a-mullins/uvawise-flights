package edu.uvawise.flights.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    onFlightSearch: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text("Date")          // TODO changeme
        Text("Airline Name")  // TODO changeme
        Text("Flight Number") // TODO changeme
    }
}

//@Preview
//@Composable
//fun StartScreenPreview() {
//    Surface(modifier = Modifier.fillMaxSize()) {
//        StartScreen()
//    }
//}
