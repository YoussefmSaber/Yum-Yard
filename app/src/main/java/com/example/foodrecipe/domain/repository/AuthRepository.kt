package com.example.foodrecipe.domain.repository

import com.example.foodrecipe.domain.model.auth.LoginData
import com.example.foodrecipe.domain.model.auth.SignupData

interface AuthRepository {

    suspend fun login(loginData: LoginData)

    suspend fun signup(signupData: SignupData)

    suspend fun passwordReset(userEmail: String, newPassword: String)

    suspend fun logout()
}