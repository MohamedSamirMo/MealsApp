package com.example.mealsapp.di

import com.example.domin.repo.mainscreen.MainScreenRepo
import com.example.domin.usecase.mainscreen.GetMealsRemote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    //Main
    @Provides
    fun provideGetMealsUseCase(mainRepo: MainScreenRepo): GetMealsRemote {
        return GetMealsRemote(mainRepo)

    }









}