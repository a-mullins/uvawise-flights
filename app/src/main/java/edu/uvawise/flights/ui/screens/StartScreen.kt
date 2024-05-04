package edu.uvawise.flights.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    onSearchSubmit: (
        date: String,
        airline: String,
        flightNum: String
    ) -> Unit,
) {
    Column(
        //verticalArrangement = Arrangement.Center,
        //horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(
                horizontal = 16.dp,
                vertical = 20.dp,
            )
            .fillMaxWidth()
    ) {
        var dateStr by remember { mutableStateOf("") }
        var airlineStr by remember { mutableStateOf("") }
        var flightStr by remember { mutableStateOf("") }

        // date
        // TODO use a date picker?
        Row {
            TextField(
                value = dateStr,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                onValueChange = { dateStr = it },
                label = { Text("Date") },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next,
            ),
                singleLine = true,
            )
        }

        // airline name
        Row {
            TextField(
                value = airlineStr,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                onValueChange = { airlineStr = it },
                label = { Text("Airline Name") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next,
                ),
                singleLine = true,
            )
        }

        // flight num
        // TODO could change this to two seperate fields to make it
        //     easier for users to enter their flight number.
        //     they are usually something like BA 555, so we could
        //     split the alpha and numeric parts.
        Row {
            TextField(
                value = flightStr,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                onValueChange = { flightStr = it },
                label = { Text("Flight Number") },
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done,
            ),
                singleLine = true,
            )
        }

        // search button
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = {
                    onSearchSubmit(
                        dateStr,
                        airlineStr,
                        flightStr)
                },
                //modifier = Modifier.
            ) {
                Text(
                    text = "Search",
                )
            }
        }
    }
}

@Preview
@Composable
fun StartScreenPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        StartScreen(onSearchSubmit = {date, airline, flight -> })
    }
}
