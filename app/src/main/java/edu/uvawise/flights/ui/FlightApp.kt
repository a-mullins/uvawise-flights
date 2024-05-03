package edu.uvawise.flights.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import edu.uvawise.flights.R

enum class FlightScreen(@StringRes val title: Int) {
    Start(R.string.start_screen_title)
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
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = FlightScreen.Start.name) {
                StartScreen(
                    modifier = Modifier, // TODO add margins here.
                    onFlightSearch = { }
                )
            }
        }
    }

}

@Preview
@Composable
fun FlightAppPreview() {
    FlightApp()
}