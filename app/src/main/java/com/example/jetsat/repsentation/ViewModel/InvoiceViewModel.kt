package com.example.jetsat.repsentation.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetsat.domain.model.Invoice
import com.example.jetsat.domain.repository.InvoiceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InvoiceViewModel @Inject constructor(
    private val  invoiceRepository: InvoiceRepository
) :ViewModel() {
    private val _invoiceList = MutableStateFlow<List<Invoice>> (emptyList())

    val invoiceList :StateFlow<List<Invoice>> = _invoiceList

    var invoice by mutableStateOf(Invoice())

    init {
        viewModelScope.launch {
            invoiceRepository.getInvoice().map {
                _invoiceList.value = it
            }
        }
    }


    fun saveUptade(){
        viewModelScope.launch {
            invoiceRepository.saveUpdateInvoice(invoice)
        }
    }

    fun delete(id:Int){
        viewModelScope.launch {
            invoiceRepository.deleteInvoice(id)
        }
    }

}