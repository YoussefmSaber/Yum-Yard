package com.example.foodrecipe.di

import com.example.foodrecipe.data.repository.MealsRepositoryImpl
import com.example.foodrecipe.domain.repository.MealsRepository
import com.example.foodrecipe.domain.usecase.get.filter.FilterByAreaUseCase
import com.example.foodrecipe.domain.usecase.get.filter.FilterByCategoryUseCase
import com.example.foodrecipe.domain.usecase.get.filter.FilterByIngredientUseCase
import com.example.foodrecipe.domain.usecase.get.general.GetAllCategorizeUseCase
import com.example.foodrecipe.domain.usecase.get.using_value.GetMealByIdUseCase
import com.example.foodrecipe.domain.usecase.get.using_value.GetMealByNameUseCase
import com.example.foodrecipe.domain.usecase.get.general.GetMealsUseCase
import com.example.foodrecipe.domain.usecase.get.general.GetRandomMealUseCase
import com.example.foodrecipe.domain.usecase.get.listing.ListAllAreasUseCase
import com.example.foodrecipe.domain.usecase.get.listing.ListAllCategoriesUseCase
import com.example.foodrecipe.domain.usecase.get.listing.ListAllIngredientsUseCase
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logging
import org.koin.dsl.module

// Koin module for dependency injection
val appModule = module {
    // Provides a single instance of HttpClient
    single {
        HttpClient(Android) {
            // Install Logging feature for debugging network requests
            install(Logging) {
                level = LogLevel.ALL // Log all requests and responses
            }
            // Install JsonFeature for serialization/deserialization
            install(JsonFeature) {
                // Use KotlinxSerializer for JSON handling
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    ignoreUnknownKeys = true // Ignore unknown keys in JSON response
                    isLenient = true // Be lenient with JSON parsing
                    encodeDefaults = false // Don't encode default values
                })
            }
        }
    }

    // Provides a single instance of MealsRepository
    single<MealsRepository> { MealsRepositoryImpl(get()) }

    // Provides use cases - Grouped by functionality for better organization

    // General meal retrieval use cases
    single { GetMealsUseCase(get()) }
    single { GetRandomMealUseCase(get()) }
    single { GetAllCategorizeUseCase(get()) }

    // Use cases for retrieving meals by specific values
    single { GetMealByIdUseCase(get()) }
    single { GetMealByNameUseCase(get()) }

    // Use cases for filtering meals
    single { FilterByCategoryUseCase(get()) }
    single { FilterByAreaUseCase(get()) }
    single { FilterByIngredientUseCase(get()) }

    // Use cases for listing categories, areas, and ingredients
    single { ListAllCategoriesUseCase(get()) }
    single { ListAllAreasUseCase(get()) }
    single { ListAllIngredientsUseCase(get()) }
}