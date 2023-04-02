package com.mydomain.shopping.domain

import com.mydomain.shopping.data.ProductRepositoryImpl

class DeleteProductUseCase (private val productRepository: ProductRepository){
    fun deleteProduct(product: Product){
        productRepository.deleteProduct(product)
    }


    }
