package com.example.foodrecipe.domain.usecase.auth

import android.util.Log
import com.example.foodrecipe.domain.model.auth.LoginData
import com.example.foodrecipe.domain.repository.AuthRepository
import com.example.foodrecipe.domain.usecase.recipe.BaseUseCase

class LoginUseCase(val repository: AuthRepository) : BaseUseCase<LoginData, Unit>() {
    override suspend fun execute(params: LoginData) {
        val response = repository.login(params)
        Log.d("Login data", "login response is: $response")
    }
}