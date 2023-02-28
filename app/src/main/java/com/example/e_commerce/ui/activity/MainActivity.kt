package com.example.e_commerce.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.e_commerce.R
import com.example.e_commerce.adpter.Adapter
import com.example.e_commerce.models.ProductData
import com.example.e_commerce.utils.ApplicationClass
import com.example.myapplication.viewmodel.MainViewModel
import com.example.myapplication.viewmodel.MainViewModelFactory
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity(),Adapter.OnItemClickListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
   private lateinit var auth:FirebaseAuth
   private lateinit var productAdapter: Adapter
   private lateinit var recyclerView: RecyclerView


   lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {


      super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)
      recyclerView=findViewById(R.id.rv_productlist)


        val repository = (application as ApplicationClass).productRepository
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)
        recyclerView.layoutManager = GridLayoutManager(this@MainActivity,2)
        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
        mainViewModel.productList.observe(this) {
            Log.d("productdata",it.toString())
            productAdapter=Adapter(this@MainActivity, it,this)
            recyclerView.adapter=productAdapter
        }
        auth = FirebaseAuth.getInstance()

    }

    override fun onItemClick(item: ProductData, position: Int) {
        Log.d("Item",item.toString())
        var intent=Intent(applicationContext,ProductActivity::class.java)
        intent.putExtra("PRODUCTID",item.id)
        intent.putExtra("PRODUCTIMAGE",item.image)
        intent.putExtra("PRODUCTCATAGORY",item.category)
        intent.putExtra("PRODUCTDESCRIPTION",item.description)
        intent.putExtra("PRODUCTNAME",item.title)
        intent.putExtra("PRODUCTPRICE",item.price)
        startActivity(intent)
    }
}