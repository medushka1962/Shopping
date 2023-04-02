package com.mydomain.shopping.domain

import androidx.lifecycle.LiveData

interface ProductRepository {

    fun addProduct(product: Product)

    fun deleteProduct(product: Product)

    fun editProduct(product: Product)

    fun getProductById(productId: Int): Product

    fun getShopList() : LiveData<List<Product>>
}