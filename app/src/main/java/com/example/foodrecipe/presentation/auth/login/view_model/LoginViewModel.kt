package com.example.foodrecipe.presentation.auth.login.view_model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodrecipe.domain.model.auth.LoginData
import com.example.foodrecipe.domain.usecase.auth.LoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {

    fun login(email: String, password: String) {
        Log.d("ViewModel", "login: Have been called")
        viewModelScope.launch {
            try {
                loginUseCase.invoke(LoginData(email, password)).collect { resource ->
                    Log.d("ViewModel", "login: $resource")
                }
            } catch (e: Exception) {
                Log.d("ViewModel", "login: ${e.message}")
            }
        }
    }
}