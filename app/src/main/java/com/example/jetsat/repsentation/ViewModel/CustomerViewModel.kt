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

    fun onDeleteCustomer(id:Int){
        viewModelScope.launch {
            customerRepository.deleteCustomer(id)
        }
    }

    fun onEditCustomer(customerEdit: Customer){

        customer = customer.copy(
            id = customerEdit.id,
            email = customerEdit.email,
            name = customerEdit.name,
            phone = customerEdit.phone,
            address = customerEdit.address
        )
    }

    fun onNameChange(newName:String){
        customer = customer.copy(
            name = newName
        )
    }

    fun onEmailChange(newEmail:String){
        customer = customer.copy(
            email = newEmail
        )
    }

    fun onPhoneChange(newPhone:String){
        customer = customer.copy(
            phone = newPhone
        )
    }

    fun onAddressChange(newAddress:String){
        customer = customer.copy(
            address = newAddress
        )
    }

}