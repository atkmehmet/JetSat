package com.example.jetsat.repsentation.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetsat.domain.model.Customer
import com.example.jetsat.domain.repository.CustomerRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CustomerViewModel @Inject constructor (
    private val customerRepository: CustomerRepository
):ViewModel() {

   private var _customerList = MutableStateFlow<List<Customer>>(emptyList())
    var customerList : StateFlow<List<Customer>> = _customerList
    var customer by mutableStateOf(Customer())

    init {
        viewModelScope.launch {
              customerRepository.getCustomer().collect{
                  _customerList.value = it
              }
        }
    }

    fun saveUpdateCustomer(){
        viewModelScope.launch {
            customerRepository.saveUpdateCustomer(customer)
        }
    }

    fun deleteCustomer(id:Int){
        viewModelScope.launch {
            customerRepository.deleteCustomer(id)
        }
    }
}