package com.mydomain.shopping.domain

class EditProductUseCase (private val productRepository: ProductRepository){
    fun editProduct(product: Product){
        productRepository.editProduct(product)
    }
}