package com.mydomain.shopping.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.mydomain.shopping.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: ShopListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRecyclerView()
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.shopList.observe(this) {
            adapter.shopList = it
        }
    }
    private fun setRecyclerView(){
        val rvShopList = findViewById<RecyclerView>(R.id.rv_shop_list)
        adapter = ShopListAdapter()
        rvShopList.adapter = adapter
        rvShopList.recycledViewPool.setMaxRecycledViews(ShopListAdapter.VIEW_TYPE_ENABLED,ShopListAdapter.MAX_POOL_SIZE)
        rvShopList.recycledViewPool.setMaxRecycledViews(ShopListAdapter.VIEW_TYPE_DISABLED,ShopListAdapter.MAX_POOL_SIZE)

    }


}




