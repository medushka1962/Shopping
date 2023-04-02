package com.mydomain.shopping.domain

import androidx.lifecycle.LiveData

class GetShopListUseCase (private val productRepository: ProductRepository){


    fun getShopList() : LiveData<List<Product>> {
     return productRepository.getShopList()

    }
}