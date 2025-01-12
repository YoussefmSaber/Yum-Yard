package com.example.foodrecipe.data.repository

import android.util.Log
import com.example.foodrecipe.domain.model.auth.LoginData
import com.example.foodrecipe.domain.model.auth.SignupData
import com.example.foodrecipe.domain.repository.AuthRepository
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.SignOutScope
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put

class AuthRepositoryImpl(private val client: SupabaseClient,) : AuthRepository {

    override suspend fun login(loginData: LoginData) {
        Log.d("Repository", "login: have been called")
        client.auth.signInWith(Email) {
            email = loginData.email
            password = loginData.password
        }
        Log.d("Login", "login: ${client.auth.currentSessionOrNull()}")
    }

    override suspend fun signup(signupData: SignupData) {
        client.auth.signUpWith(Email) {
            email = signupData.email
            password = signupData.password
            data = buildJsonObject {
                put("name", signupData.name)
            }
        }
    }

    override suspend fun passwordReset(userEmail: String, newPassword: String) {
        client.auth.resetPasswordForEmail(
            email = userEmail
        )
    }

    override suspend fun logout() {
        client.auth.signOut(SignOutScope.GLOBAL)
        client.auth.clearSession()
    }

    override fun saveAuthToken(token: String) {
     }

    override fun getAuthToken(): String? {
        return  null
    }

    override fun clearAuthToken() {

    }
}