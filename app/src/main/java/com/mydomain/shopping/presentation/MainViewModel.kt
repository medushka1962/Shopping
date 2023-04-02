package com.mydomain.shopping.presentation


import androidx.lifecycle.ViewModel
import com.mydomain.shopping.data.ProductRepositoryImpl
import com.mydomain.shopping.domain.DeleteProductUseCase
import com.mydomain.shopping.domain.EditProductUseCase
import com.mydomain.shopping.domain.GetShopListUseCase
import com.mydomain.shopping.domain.Product

class MainViewModel : ViewModel() {

    private val repository = ProductRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteProductUseCase = DeleteProductUseCase(repository)
    private val editProductUseCase = EditProductUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteProduct(product: Product) {
        deleteProductUseCase.deleteProduct(product)
    }

    fun changeEnableState(product: Product) {
        val newItem = product.copy(enabled = !product.enabled)
        editProductUseCase.editProduct(newItem)
    }
}