package com.mydomain.shopping.domain

class GetShopListUseCase (private val productRepository: ProductRepository){


    fun getShopList() :List<Product>{
     return productRepository.getShopList()

    }
}