package com.example.foodrecipe.di

import com.example.foodrecipe.BuildConfig
import com.example.foodrecipe.data.repository.AuthRepositoryImpl
import com.example.foodrecipe.data.repository.RecipesRepositoryImpl
import com.example.foodrecipe.domain.repository.AuthRepository
import com.example.foodrecipe.domain.repository.RecipesRepository
import com.example.foodrecipe.domain.usecase.auth.LoginUseCase
import com.example.foodrecipe.domain.usecase.auth.LogoutUseCase
import com.example.foodrecipe.domain.usecase.auth.SignupUseCase
import com.example.foodrecipe.domain.usecase.recipe.filter.FilterByAreaUseCase
import com.example.foodrecipe.domain.usecase.recipe.filter.FilterByCategoryUseCase
import com.example.foodrecipe.domain.usecase.recipe.general.GetAllCategorizeUseCase
import com.example.foodrecipe.domain.usecase.recipe.general.GetMealsUseCase
import com.example.foodrecipe.domain.usecase.recipe.general.GetRandomMealsUseCase
import com.example.foodrecipe.domain.usecase.recipe.listing.ListAllAreasUseCase
import com.example.foodrecipe.domain.usecase.recipe.listing.ListAllCategoriesUseCase
import com.example.foodrecipe.domain.usecase.recipe.using_value.GetMealByIdUseCase
import com.example.foodrecipe.domain.usecase.recipe.using_value.GetMealByNameUseCase
import com.example.foodrecipe.presentation.app.details.view_model.DetailsViewModel
import com.example.foodrecipe.presentation.app.search.view_model.SearchViewModel
import com.example.foodrecipe.presentation.auth.login.view_model.LoginViewModel
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

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
    single<RecipesRepository> { RecipesRepositoryImpl(get()) }
    single<AuthRepository> { AuthRepositoryImpl(get()) }

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

    // Use cases for authentication
    single { LoginUseCase(get()) }
    single { SignupUseCase(get()) }
    single { LogoutUseCase(get()) }

    viewModel { SearchViewModel(get()) }
    viewModel { DetailsViewModel(get()) }
    viewModel { LoginViewModel(get()) }
}