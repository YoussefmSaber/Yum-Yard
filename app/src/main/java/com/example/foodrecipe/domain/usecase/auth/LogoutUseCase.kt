package com.example.foodrecipe.domain.usecase.auth

import com.example.foodrecipe.domain.repository.AuthRepository
import com.example.foodrecipe.domain.usecase.recipe.BaseUseCase

class LogoutUseCase(val repository: AuthRepository) : BaseUseCase<Unit, Unit>() {
    override suspend fun execute(params: Unit) {
        repository.logout()
    }
}