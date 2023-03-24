package com.example.e_commerce.adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce.R
import com.example.e_commerce.models.ProductCategory


class CategoryAdapter(
    val context: Context,
    val ProductCategory: List<ProductCategory>,
    val onCategoryItemClickListener: OnCategoryItemClickListener,

) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var category_button: TextView = itemView.findViewById(R.id.btn_Item_Category)
    }

    interface OnCategoryItemClickListener {
        fun onCategoryItemClick(item: ProductCategory, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater =
            LayoutInflater.from(context).inflate(R.layout.categorymain_item, parent, false)
        return ViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
     onCategoryItemClickListener.onCategoryItemClick(ProductCategory.get(position),position)
        }
        val userList = ProductCategory.get(position)
        holder.category_button.text = userList.category
    }

    override fun getItemCount(): Int {
        return ProductCategory.size
    }
}