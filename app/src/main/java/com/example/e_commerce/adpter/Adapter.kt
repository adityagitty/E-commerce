package com.example.e_commerce.adpter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.e_commerce.R
import com.example.e_commerce.models.ProductData

class Adapter(
    val context: Context,
    val list: List<ProductData>,
    val itemClickListener: OnItemClickListener
    ) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {


    interface OnItemClickListener {
        fun onItemClick(item: ProductData, position: Int)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(list.get(position), position)
        }

        val currentItem = list.get(position)
        holder.productName.text = currentItem.title
        holder.productType.text = currentItem.category
        holder.productPrice.text = currentItem.price.toString()

        Glide.with(context)
            .load(currentItem.image)
            .into(holder.productImage)

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImage: ImageView = itemView.findViewById(R.id.product_image)
        val productName: TextView = itemView.findViewById(R.id.product_name)
        val productType: TextView = itemView.findViewById(R.id.product_type)
        val productPrice: TextView = itemView.findViewById(R.id.product_price)

    }

    fun getProductList():List<ProductData>
    {
        return list
    }
}