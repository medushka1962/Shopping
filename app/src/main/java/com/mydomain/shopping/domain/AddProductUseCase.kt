package com.mydomain.shopping.domain

class AddProductUseCase(private val productRepository: ProductRepository) {
    fun addProduct(product: Product){
        productRepository.addProduct(product)
    }
}