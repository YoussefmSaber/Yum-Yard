package com.example.foodrecipe.domain.repository

interface AuthRepository {

    suspend fun login(email: String, password: String)

    suspend fun signup(name: String, email: String, password: String)

    suspend fun passwordReset(userId: String, newPassword: String)
}