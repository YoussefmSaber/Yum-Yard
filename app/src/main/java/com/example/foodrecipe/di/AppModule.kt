package com.example.foodrecipe.di

import com.example.foodrecipe.BuildConfig
import com.example.foodrecipe.data.repository.MealsRepositoryImpl
import com.example.foodrecipe.domain.repository.MealsRepository
import com.example.foodrecipe.domain.usecase.get.filter.FilterByAreaUseCase
import com.example.foodrecipe.domain.usecase.get.filter.FilterByCategoryUseCase
import com.example.foodrecipe.domain.usecase.get.general.GetAllCategorizeUseCase
import com.example.foodrecipe.domain.usecase.get.general.GetMealsUseCase
import com.example.foodrecipe.domain.usecase.get.general.GetRandomMealsUseCase
import com.example.foodrecipe.domain.usecase.get.listing.ListAllAreasUseCase
import com.example.foodrecipe.domain.usecase.get.listing.ListAllCategoriesUseCase
import com.example.foodrecipe.domain.usecase.get.using_value.GetMealByIdUseCase
import com.example.foodrecipe.domain.usecase.get.using_value.GetMealByNameUseCase
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.realtime.Realtime
import org.koin.dsl.module
import kotlin.time.Duration.Companion.seconds

// Koin module for dependency injection
val appModule = module {
    // Provides a single instance of HttpClient
    single {
        createSupabaseClient(
            supabaseUrl = BuildConfig.API_URL,
            supabaseKey = BuildConfig.API_KEY
        ) {
            install(Auth)
            install(Postgrest)
        }
    }

    // Provides a single instance of MealsRepository
    single<MealsRepository> { MealsRepositoryImpl(get()) }

    // Provides use cases - Grouped by functionality for better organization

    // General meal retrieval use cases
    single { GetMealsUseCase(get()) }
    single { GetRandomMealsUseCase(get()) }
    single { GetAllCategorizeUseCase(get()) }

    // Use cases for retrieving meals by specific values
    single { GetMealByIdUseCase(get()) }
    single { GetMealByNameUseCase(get()) }

    // Use cases for filtering meals
    single { FilterByCategoryUseCase(get()) }
    single { FilterByAreaUseCase(get()) }

    // Use cases for listing categories, areas, and ingredients
    single { ListAllCategoriesUseCase(get()) }
    single { ListAllAreasUseCase(get()) }
}