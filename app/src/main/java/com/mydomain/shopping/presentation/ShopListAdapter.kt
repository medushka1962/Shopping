package com.mydomain.shopping.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.mydomain.shopping.R
import com.mydomain.shopping.domain.Product

class ShopListAdapter: RecyclerView.Adapter<ShopListAdapter.ProductViewHolder>() {

    var shopList = listOf<Product>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_shop_disabled,
            parent,
            false
        )
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ProductViewHolder, position: Int) {
        val shopItem = shopList[position]
        val status = if (shopItem.enabled) {
            "Active"
        } else {
            "Not active"
        }
        viewHolder.view.setOnLongClickListener {
            true
        }
        viewHolder.tvName.text = "${shopItem.name} $status"
        viewHolder.tvDisc.text = shopItem.disc
        viewHolder.tvCount.text = shopItem.count.toString()


        if (shopItem.enabled) {

            viewHolder.tvName.setTextColor(ContextCompat.getColor(
                viewHolder.view.context,
                android.R.color.holo_red_light))
        } else{
            viewHolder.tvName.setTextColor(ContextCompat.getColor(
                viewHolder.view.context,
                android.R.color.white))

        }
    }

    override fun getItemCount(): Int {
        return shopList.size
    }





    class ProductViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val tvName = view.findViewById<TextView>(R.id.tv_name)
        val tvDisc = view.findViewById<TextView>(R.id.tv_disc)
        val tvCount = view.findViewById<TextView>(R.id.tv_count)
    }

}