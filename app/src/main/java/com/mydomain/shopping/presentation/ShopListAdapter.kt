package com.mydomain.shopping.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.mydomain.shopping.R
import com.mydomain.shopping.domain.Product

class ShopListAdapter: RecyclerView.Adapter<ShopListAdapter.ProductViewHolder>() {
    var count: Int = 0

    var shopList = listOf<Product>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        Log.d("ShopListAdapter", "onCreateViewHolder, count: ${++count}")
        val layout = when (viewType) {
            VIEW_TYPE_DISABLED -> R.layout.item_shop_disabled
            VIEW_TYPE_ENABLED -> R.layout.item_shop_enabled
            else -> throw RuntimeException("Unknown view type: $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ProductViewHolder, position: Int) {
        val product = shopList[position]
        viewHolder.view.setOnLongClickListener {
            true
        }
        viewHolder.tvName.text = product.name
        viewHolder.tvDisc.text = product.disc
        viewHolder.tvCount.text =product.count.toString()


        if (product.enabled) {

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


    override fun getItemViewType(position: Int): Int {
        val item = shopList[position]
        return if (item.enabled) {
            VIEW_TYPE_ENABLED
        } else {
            VIEW_TYPE_DISABLED
        }
    }

    class ProductViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val tvName = view.findViewById<TextView>(R.id.tv_name)
        val tvDisc = view.findViewById<TextView>(R.id.tv_disc)
        val tvCount = view.findViewById<TextView>(R.id.tv_count)
    }
    companion object {

        const val VIEW_TYPE_ENABLED = 100
        const val VIEW_TYPE_DISABLED = 101

        const val MAX_POOL_SIZE = 100
    }

}