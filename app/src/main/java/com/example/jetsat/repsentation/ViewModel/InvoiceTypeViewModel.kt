package com.example.jetsat.repsentation.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetsat.domain.model.InvoiceType
import com.example.jetsat.domain.repository.InvoiceTypeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InvoiceTypeViewModel @Inject constructor(
    private val invoiceTypeRepository: InvoiceTypeRepository
):ViewModel() {

    private val _invoiceTypeList = MutableStateFlow<List<InvoiceType>>(emptyList())
     val invoiceTypeList :StateFlow<List<InvoiceType>> = _invoiceTypeList

    var invoiceType by mutableStateOf(InvoiceType())

    init {
        viewModelScope.launch {
            invoiceTypeRepository.getInvoiceType().map {
                _invoiceTypeList.value = it
            }
        }
    }

    fun saveUpdate(){
        viewModelScope.launch {
            invoiceTypeRepository.saveUpdateInvoiceType(invoiceType)
        }
    }

    fun delete(id:Int){
        viewModelScope.launch {
            invoiceTypeRepository.deleteInvoiceType(id)
        }
    }

    fun onCodeChange(newCode:String){
        invoiceType = invoiceType.copy(
            code = newCode

        )
    }

    fun onNameChange(newName:String){
        invoiceType = invoiceType.copy(
            name = newName

        )
    }

    fun onDescriptionChange(newDescription:String){
        invoiceType = invoiceType.copy(
            description = newDescription
        )
    }
}