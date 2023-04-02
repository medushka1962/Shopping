package com.mydomain.shopping.data

import com.mydomain.shopping.domain.Product
import com.mydomain.shopping.domain.ProductRepository

object ProductRepositoryImpl : ProductRepository {

    private val shopList = mutableListOf<Product>()
    private var autoIncrementId = 0

    init {
        for (i in 0 until 10){
            val item = Product("Пиво $i","крепкое", i ,true)
            addProduct(item)
        }
    }

    override fun addProduct(product: Product) {
        if (product.id == Product.UNDEFINED_ID) {
            product.id = autoIncrementId++
        }
        shopList.add(product)
    }

    override fun deleteProduct(product: Product) {
        shopList.remove(product)
    }

    override fun editProduct(product: Product) {
        val oldElement = getProductById(product.id)
        shopList.remove(oldElement)
        addProduct(product)
    }

    override fun getProductById(productId: Int): Product {
        return shopList.find {
            it.id == productId
        } ?: throw RuntimeException("Element with id $productId not found" )
    }

    override fun getShopList(): List<Product> {
       return shopList.toList()
    }
}