package com.example.foodrecipe.domain.usecase.auth

import android.util.Log
import com.example.foodrecipe.domain.model.SignupData
import com.example.foodrecipe.domain.repository.AuthRepository
import com.example.foodrecipe.domain.usecase.recipe.BaseUseCase

class SignupUseCase(val repository: AuthRepository) : BaseUseCase<SignupData, Unit>() {
    override suspend fun execute(params: SignupData) {
        val response = repository.signup(params)
        Log.d("Signup data", "signup response is: $response")
    }
}