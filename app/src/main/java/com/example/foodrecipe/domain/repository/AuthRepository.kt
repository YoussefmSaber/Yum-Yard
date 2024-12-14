package com.example.foodrecipe.domain.repository

import com.example.foodrecipe.domain.model.LoginData
import com.example.foodrecipe.domain.model.SignupData

interface AuthRepository {

    suspend fun login(loginData: LoginData)

    suspend fun signup(signupData: SignupData)

    suspend fun passwordReset(userEmail: String, newPassword: String)

    suspend fun logout()
}