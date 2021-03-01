package com.example.androiddevchallenge

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController

@Composable
fun MyApp() {
    val dogs = DogsData().dogs
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable(
            "home"
        ) {
            HomePage(navController = navController, dogs)
        }
        composable(
            "detail/{index}",
            arguments = listOf(navArgument("index") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("index")
            DetailPage(navController, dogs[id ?: 0])
        }
    }
}