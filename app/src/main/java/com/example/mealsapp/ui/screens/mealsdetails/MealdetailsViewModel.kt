package com.example.mealsapp.ui.screens.mealsdetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
@HiltViewModel
class MealdetailsViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {
    private val _mealName = MutableStateFlow("")
    private val _mealDescription = MutableStateFlow("")
    private val _mealImageUrl = MutableStateFlow("")

    val mealName = _mealName.asStateFlow()
    val mealDescription = _mealDescription.asStateFlow()
    val mealImageUrl = _mealImageUrl.asStateFlow()

    init {
        val mealName = savedStateHandle.get<String>("mealName")
        val mealDescription = savedStateHandle.get<String>("mealDescription")
        val mealImageUrl = savedStateHandle.get<String>("mealImageUrl")

        mealName?.let { _mealName.value = it }
        mealDescription?.let { _mealDescription.value = it }
        mealImageUrl?.let { _mealImageUrl.value = it }
    }
}
