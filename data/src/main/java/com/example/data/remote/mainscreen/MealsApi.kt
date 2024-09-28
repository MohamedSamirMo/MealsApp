package com.example.data.remote.mainscreen

import com.example.domin.entity.mainscreen.MealModelItem
import retrofit2.http.GET

interface MealsApi {
    @GET("api/json/v1/1/categories.php")
    suspend fun getMeals(): MealModelItem

    // www.themealdb.com/

}