package com.example.data.repo.mainscreen

import com.example.data.remote.mainscreen.MealsApi
import com.example.domin.entity.mainscreen.MealModelItem
import com.example.domin.repo.mainscreen.MainScreenRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepoImpl constructor(private val api: MealsApi) : MainScreenRepo {
    override suspend fun getMealsRemote(): MealModelItem = withContext(Dispatchers.IO){

        return@withContext api.getMeals()
    }
}