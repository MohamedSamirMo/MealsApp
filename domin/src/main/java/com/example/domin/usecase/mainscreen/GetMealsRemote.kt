package com.example.domin.usecase.mainscreen

import com.example.domin.entity.mainscreen.MealModelItem
import com.example.domin.repo.mainscreen.MainScreenRepo

class GetMealsRemote(private val mainScreenRepo: MainScreenRepo)  {
    suspend operator fun invoke(): MealModelItem = mainScreenRepo.getMealsRemote()

}