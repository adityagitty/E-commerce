package com.example.e_commerce.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.navigation.ui.AppBarConfiguration
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import androidx.viewpager2.widget.ViewPager2
import com.example.e_commerce.R
import com.example.e_commerce.adpter.Adapter
import com.example.e_commerce.adpter.CategoryAdapter
import com.example.e_commerce.adpter.FragmentAdapter
import com.example.e_commerce.models.ProductData
import com.example.e_commerce.utils.ApplicationClass
import com.example.e_commerce.utils.Constants.ALL
import com.example.e_commerce.utils.Constants.ELECTRONICS
import com.example.e_commerce.utils.Constants.JEWELLERY
import com.example.e_commerce.utils.Constants.MENS
import com.example.e_commerce.utils.Constants.WOMENS

import com.example.myapplication.viewmodel.MainViewModel
import com.example.myapplication.viewmodel.MainViewModelFactory
import com.google.android.material.tabs.TabLayout
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity(),Adapter.OnItemClickListener {

    private val productCategory = arrayOf(
        ALL,MENS, JEWELLERY,ELECTRONICS,
        WOMENS
    )
    private lateinit var appBarConfiguration: AppBarConfiguration
   private lateinit var auth:FirebaseAuth
   private lateinit var productAdapter: Adapter
   private lateinit var recyclerView: RecyclerView
   private lateinit var categoryRecyclerView: RecyclerView
   private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2
    private lateinit var fragmentAdapter: FragmentAdapter

   lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {


      super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)
      recyclerView=findViewById(R.id.rv_productlist)
     
       tabLayout=findViewById(R.id.tab_layout)
        viewPager=findViewById(R.id.view_pager)



        fragmentAdapter= FragmentAdapter(supportFragmentManager,lifecycle)
         viewPager.adapter=fragmentAdapter
         viewPager.visibility=View.GONE
          fun requestProduct(productCategory:String,proproductData: List<ProductData>) {
               mainViewModel.productList
          }

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
       val repository = (application as ApplicationClass).productRepository


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