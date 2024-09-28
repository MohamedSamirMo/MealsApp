package com.example.mealsapp.ui.screens.mealsdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun MealsDetailsScreen(
    category: String,
    mealDescription: String,
    mealImageUrl: String
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(16.dp),
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Display the meal image
            Image(
                painter = rememberAsyncImagePainter(mealImageUrl),
                contentDescription = "Meal Image",
                modifier = Modifier
                    .size(250.dp)
                    .padding(16.dp)
            )

            // Display the meal category
            Text(
                text = category,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 8.dp),
                textAlign = TextAlign.Center
            )

            // Display the meal description
            Text(
                text = mealDescription,
                fontSize = 16.sp,
                color = Color.DarkGray,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Justify
            )
        }
    }
}
