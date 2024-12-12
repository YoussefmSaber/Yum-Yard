package com.example.foodrecipe.di

import com.example.foodrecipe.common.HttpRoutes
import com.example.foodrecipe.data.repository.MealsRepositoryImpl
import com.example.foodrecipe.domain.repository.MealsRepository
import com.example.foodrecipe.domain.usecase.GetMealsUseCase
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logging
import io.ktor.client.request.url
import org.koin.dsl.module

val appModule = module {
    // Ktor client
    single {
        HttpClient(Android) {
            defaultRequest {
                url(HttpRoutes.MEALS)
            }
            install(Logging) {
                level = LogLevel.ALL
            }
            install(JsonFeature) {
                serializer = KotlinxSerializer()
            }
        }
    }
    // Meals repository
    single<MealsRepository> {
        MealsRepositoryImpl(get())
    }
    // Meals useCase
    single {
        GetMealsUseCase(get())
    }

}