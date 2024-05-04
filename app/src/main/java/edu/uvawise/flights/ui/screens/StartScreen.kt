package edu.uvawise.flights.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.uvawise.flights.ui.widgets.MyDatePickerDialog

@OptIn(ExperimentalMaterial3Api::class)
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
        //var dateStr by remember { mutableStateOf("") }
        var airlineStr by rememberSaveable { mutableStateOf("") }
        var flightStr by rememberSaveable { mutableStateOf("") }
        val dateState = rememberDatePickerState()
        var dateStr: String by rememberSaveable { mutableStateOf("Select Date") }
        var showDatePicker by rememberSaveable { mutableStateOf(false) }

        if (showDatePicker) {
            MyDatePickerDialog(
                onDateSelected = { dateStr = it },
                onDismiss = { showDatePicker = false }
            )
        } else {
            Row {
                Button(
                    onClick = { showDatePicker = true },
                    modifier = Modifier
                        .defaultMinSize(minHeight = 60.dp)
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    shape = RoundedCornerShape(12)
                ) {
                    Text(text = dateStr)
                }
//            TextField(
//                value = dateStr,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 8.dp),
//                onValueChange = { dateStr = it },
//                label = { Text("Date") },
//            keyboardOptions = KeyboardOptions.Default.copy(
//                imeAction = ImeAction.Next,
//            ),
//                singleLine = true,
//            )
            }

            // airline name
            Row {
                TextField(
                    value = airlineStr,
                    modifier = Modifier
                        .defaultMinSize(minHeight = 60.dp)
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    onValueChange = { airlineStr = it },
                    label = { Text("Airline Name") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next,
                    ),
                    singleLine = true,
                    shape = RoundedCornerShape(12),
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    )
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
                        .defaultMinSize(minHeight = 60.dp)
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    onValueChange = { flightStr = it },
                    label = { Text("Flight Number") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done,
                    ),
                    singleLine = true,
                    shape = RoundedCornerShape(12),
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    )
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
                            flightStr
                        )
                    },
                    shape = RoundedCornerShape(18)
                    //modifier = Modifier.
                ) {
                    Text(
                        text = "Search",
                    )
                }
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