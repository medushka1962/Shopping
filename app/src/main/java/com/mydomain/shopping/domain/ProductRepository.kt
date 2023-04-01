package com.mydomain.shopping.domain

interface ProductRepository {

    fun addProduct(product: Product)

    fun deleteProduct(product: Product)

    fun editProduct(product: Product)

    fun getProductById(productId: Int): Product

    fun getShopList() :List<Product>
}