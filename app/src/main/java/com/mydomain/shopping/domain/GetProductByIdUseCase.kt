package com.mydomain.shopping.domain

class GetProductByIdUseCase (private val productRepository: ProductRepository){
    fun getProductById(productId: Int): Product{
       return productRepository.getProductById(productId)

    }

}