package com.example.jetsat.repsentation.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetsat.domain.model.Product
import com.example.jetsat.domain.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepository: ProductRepository
)
    :ViewModel() {

        private val _productList = MutableStateFlow<List<Product>>(emptyList())

       val productList : StateFlow <List<Product>> = _productList

       var product by mutableStateOf(Product())


    init {
        viewModelScope.launch {
            productRepository.getProducts().map {
                _productList.value = it
            }
        }
    }

    fun saveUptade(){
        viewModelScope.launch {
            productRepository.saveUpdateProduct(product)
        }
    }

    fun delete(id:Int){
        viewModelScope.launch {
            productRepository.deleteProduct(id)
        }
    }

    fun onProductNameChange(newName:String){

        product = product.copy(
            productName = newName
        )
    }
    fun onProductTakePriceChange(price:String){

        product = product.copy(
            productTakePrice = price.toDouble()
        )
    }
}