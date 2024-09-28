package com.example.mealsapp.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domin.entity.mainscreen.MealModelItem
import com.example.domin.usecase.mainscreen.GetMealsRemote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val GetMealsRemote: GetMealsRemote) : ViewModel() {
    private val  _meals= MutableStateFlow<MealModelItem>(MealModelItem(emptyList()))
    val meals = _meals.asStateFlow()

    init {
        getMeals()
    }
    private fun getMeals(){
        viewModelScope.launch {
            try {
                _meals.value=GetMealsRemote()

            }catch (e:Exception){

                println(e.message)
            }
        }
    }

}