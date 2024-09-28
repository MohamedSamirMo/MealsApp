package com.example.mealsapp.ui.screens

import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.mealsapp.Screen
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreen(
    NavCon: NavHostController? = null,
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val meals by mainViewModel.meals.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(meals.categories) { meal ->
                MealItem(
                    title = meal.strCategory ?: "",
                    imageUrl = meal.strCategoryThumb ?: ""
                ) {
                    NavCon?.navigate(
                        "${Screen.MealDetailsScreen.route}/${meal.strCategory}?mealDescription=${Uri.encode(meal.strCategoryDescription ?: "")}&mealImageUrl=${Uri.encode(meal.strCategoryThumb ?: "")}"
                    )
                }
            }
        }
    }
}
