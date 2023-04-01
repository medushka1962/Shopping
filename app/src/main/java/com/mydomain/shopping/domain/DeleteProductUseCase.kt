package com.mydomain.shopping.domain

class DeleteProductUseCase (private val productRepository: ProductRepository){
    fun deleteProduct(product: Product){
        productRepository.deleteProduct(product)
    }
}