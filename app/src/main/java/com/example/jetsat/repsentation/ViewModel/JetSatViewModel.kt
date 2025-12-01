package com.example.jetsat.repsentation.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetsat.domain.model.Product
import com.example.jetsat.domain.model.ProductItem
import com.example.jetsat.domain.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class JetSatViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    // Tek ürün (barkoddan gelen)
    private val _product = MutableStateFlow<Product?>(null)
    val product = _product.asStateFlow()

    // Barkod okuyucu state
    private val _isScannerOpen = MutableStateFlow(false)
    val isScannerOpen = _isScannerOpen.asStateFlow()

    // LISTE ==== ( sepetteki ürünler )
    private val _productList = MutableStateFlow<List<ProductItem>>(emptyList())
    val productList = _productList.asStateFlow()


    // BARKOD OKUYUCU
    fun openScanner() {
        _isScannerOpen.value = true
    }

    fun closeScanner() {
        _isScannerOpen.value = false
    }


    // BARKOD İLE ÜRÜN GETİRME
    fun onBarcodeScanned(barcode: String) {
        viewModelScope.launch {

            val found = productRepository.getProductByBarcode(barcode)

            if (found != null) {
                _product.value = found
            } else {
                // Ürün yoksa isim olarak barkodu yaz
                _product.value = Product(
                    productBarcode = barcode,
                    productName = "Ürün Bulunamadı!",
                    productSoldPrice = 0.0
                )
            }
        }
    }


    // Product temizle (bir sonraki okuma için)
    fun onCleanProduct() {
        _product.value = null
    }


    // ===============================
    //   SEPET / LİSTE İŞLEMLERİ
    // ===============================

    // Ürünü listeye ekle
    fun addProductToList(product: Product) {
        val currentList = _productList.value

        val existing = currentList.find { it.product.productBarcode == product.productBarcode }

        _productList.value = if (existing != null) {
            // Aynı ürün varsa adet artır
            currentList.map {
                if (it.product.productBarcode == product.productBarcode)
                    it.copy(quantity = it.quantity + 1)
                else it
            }
        } else {
            // Yeni ürün ekle
            currentList + ProductItem(product)
        }
    }

    // Adet artır
    fun increaseQuantity(item: ProductItem) {
        _productList.value = _productList.value.map {
            if (it.product.productBarcode == item.product.productBarcode)
                it.copy(quantity = it.quantity + 1)
            else it
        }
    }

    // Adet azalt (1 ise sil)
    fun decreaseQuantity(item: ProductItem) {
        _productList.value = _productList.value.mapNotNull {
            when {
                it.product.productBarcode != item.product.productBarcode -> it
                it.quantity > 1 -> it.copy(quantity = it.quantity - 1)
                else -> null // adet 1 ise ürün silinsin
            }
        }
    }

    // Ürünü tamamen sil
    fun deleteProduct(item: ProductItem) {
        _productList.value = _productList.value.filterNot {
            it.product.productBarcode == item.product.productBarcode
        }
    }

    // Genel toplam hesaplama
    fun getTotalPrice(): Double {
        return _productList.value.sumOf { it.totalPrice }
    }
}
