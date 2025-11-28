package com.example.jetsat.repsentation.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetsat.data.local.dao.CategoryDao
import com.example.jetsat.domain.model.Category
import com.example.jetsat.domain.repository.CategoryRepository
import com.example.jetsat.mapper.toCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
    class CategoryViewModel @Inject constructor(
        private val categoryRepository: CategoryRepository
    ):ViewModel() {

        var category by mutableStateOf(Category())
        private var _listCategory = MutableStateFlow<List<Category>>(emptyList())
        val categories :StateFlow<List<Category>> = _listCategory

    init {
                  viewModelScope.launch {
                      categoryRepository.getCategoris().collect{
                          _listCategory.value = it
                      }
                  }
        }

    fun saveUpdate(){
        viewModelScope.launch {
            categoryRepository.saveUpdateCategory(category)
        }
    }

    fun onDeleteCategory(id:Int){
        viewModelScope.launch {
            categoryRepository.deleteCategory(id)
        }
    }
    fun onEditCategory(category: Category){
        this.category = category.copy(
            id = category.id,
            categoryName = category.categoryName
        )
    }

    fun onNameChange(newName:String){
        category = category.copy(
            categoryName = newName
        )
    }

    }