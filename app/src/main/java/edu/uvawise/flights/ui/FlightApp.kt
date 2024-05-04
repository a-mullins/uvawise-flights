package edu.uvawise.flights.ui

import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import edu.uvawise.flights.R
import edu.uvawise.flights.ui.screens.ErrorScreen
import edu.uvawise.flights.ui.screens.ResultsScreen
import edu.uvawise.flights.ui.screens.StartScreen
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

const private val TAG = "FlightApp.kt"

enum class FlightScreen(@StringRes val title: Int) {
    Start(R.string.start_screen_title),
    Results(R.string.results_title),
    Error(R.string.nothing_found_title),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlightAppTopBar(
    currentScreen: FlightScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text("Flight Wise", maxLines = 1) // TODO convert to StringRes
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
          containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back" // TODO convert to StringRes
                    )
                }
            }
        }
    )
}

@Composable
fun FlightApp(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = FlightScreen.valueOf(
        backStackEntry?.destination?.route ?: FlightScreen.Start.name
    )

    var dateStr by rememberSaveable { mutableStateOf("") }
    var airlineName by rememberSaveable { mutableStateOf("") }
    var flightNumber by rememberSaveable { mutableStateOf("") }

    Scaffold(
        topBar = {
            FlightAppTopBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = FlightScreen.Start.name,
            modifier = Modifier
                //.padding(innerPadding)
                .fillMaxSize()
        ) {
            composable(route = FlightScreen.Start.name) {
                StartScreen(
                    modifier = Modifier.padding(innerPadding),
                    onSearchSubmit = { date, name, num ->
                        // TODO search for flight
                        //      Conduct a flight search and get the results into the
                        //      result screen somehow.
                        dateStr = date
                        airlineName = name
                        flightNumber = num
                        navController.navigate(FlightScreen.Results.name)
                    }
                )
            }
            composable(route = FlightScreen.Results.name) {
                Log.d(TAG, String.format("date: %s\nname: %s\nflight: %s", dateStr, airlineName, flightNumber))
                ResultsScreen(
                    dateStr,
                    airlineName,
                    flightNumber
                )
            }
            composable(route = FlightScreen.Error.name) {
                ErrorScreen()
            }
        }
    }

}

@Preview
@Composable
fun FlightAppPreview() {
    FlightApp()
}