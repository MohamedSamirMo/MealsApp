package com.example.domin.repo.mainscreen

import com.example.domin.entity.mainscreen.MealModelItem

interface MainScreenRepo {
    suspend fun getMealsRemote(): MealModelItem

}