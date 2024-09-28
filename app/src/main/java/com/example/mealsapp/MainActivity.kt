package com.example.mealsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mealsapp.ui.screens.MainScreen
import com.example.mealsapp.ui.screens.mealsdetails.MealsDetailsScreen
import com.example.mealsapp.ui.theme.MealsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealsAppTheme {
                MainAppController()
            }
        }
    }
}

@Composable
fun MainAppController() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "mainScreen") {
        composable(Screen.MainScreen.route) { MainScreen(navController) }
        composable(
            route = "${Screen.MealDetailsScreen.route}/{category}?mealDescription={mealDescription}&mealImageUrl={mealImageUrl}",
            arguments = listOf(
                navArgument("category") { type = NavType.StringType },
                navArgument("mealDescription") { type = NavType.StringType; defaultValue = "" },
                navArgument("mealImageUrl") { type = NavType.StringType; defaultValue = "" }
            )
        ) { backStackEntry ->
            MealsDetailsScreen(
                category = backStackEntry.arguments?.getString("category") ?: "",
                mealDescription = backStackEntry.arguments?.getString("mealDescription") ?: "",
                mealImageUrl = backStackEntry.arguments?.getString("mealImageUrl") ?: ""
            )
        }


    }}