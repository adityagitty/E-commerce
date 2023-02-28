package com.example.e_commerce.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

import android.widget.TextView
import com.example.e_commerce.R
import com.example.e_commerce.R.*
import com.example.e_commerce.R.id.price


class ProductActivity : AppCompatActivity(),View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_product)

        val product_name=findViewById<TextView>(R.id.product_name)
        val add_to_cart=findViewById<Button>(R.id.add_to_cart)
        val product_full_desc=findViewById<TextView>(id.prdct_desc)
        val product_price=findViewById<TextView>(price)
        val product_image=findViewById<ImageView>(R.id.full_prdct_image)
        product_name.setText(getIntent().getExtras()?.getString("PRODUCTNAME"))
        product_full_desc.setText(getIntent().getExtras()?.getString("PRODUCTDESCRIPTION"))
        product_price.setText(getIntent().getExtras()?.getDouble("PRODUCTPRICE").toString())
         val prdct_image=getIntent().getIntExtra("PRODUCTIMAGE",0);
        product_image.setImageResource(prdct_image)


    }

    override fun onClick(v: View?) {

    }
}