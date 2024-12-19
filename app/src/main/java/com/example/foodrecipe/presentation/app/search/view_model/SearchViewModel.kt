package com.example.foodrecipe.presentation.app.search.view_model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodrecipe.common.Resource
import com.example.foodrecipe.domain.model.recipe.Meal
import com.example.foodrecipe.domain.usecase.recipe.using_value.GetMealByNameUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SearchViewModel(private val getMealByName: GetMealByNameUseCase) : ViewModel() {

    // State for the current search query
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    // State for search results (meals)
    private val _searchedRecipes = MutableStateFlow<List<Meal>>(emptyList())
    val searchedRecipes: StateFlow<List<Meal>> = _searchedRecipes

    // Update search query
    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
        performSearch(query)
    }

    // Perform search using the use case
    private fun performSearch(query: String) {
        if (query.isEmpty()) {
            _searchedRecipes.value = emptyList()
            return
        }
        viewModelScope.launch {
            getMealByName.invoke(query).collect { resource ->
                when (resource) {
                    is Resource.Success -> {
                        _searchedRecipes.value = resource.data ?: emptyList()
                    }
                    is Resource.Error -> {
                        _searchedRecipes.value = emptyList()
                    }

                    is Resource.Loading -> {
                        Log.d("TAG", "performSearch: Loading")
                    }
                }
            }
        }
    }
}