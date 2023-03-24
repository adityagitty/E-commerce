package com.example.e_commerce.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.e_commerce.api.ApiService
import com.example.e_commerce.api.RetrofitHelper
import com.example.e_commerce.models.ProductData
import com.example.e_commerce.utils.NetworkUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create


class ProductRepository(
    private val apiService: ApiService,
    val context: Context
) {



    fun getProductApiCall(categories: String?): MutableLiveData<List<ProductData>> {
        val productList = MutableLiveData<List<ProductData>>()
        val call =
            RetrofitHelper.getInstance().create(ApiService::class.java).getAllProduct(categories)
        call.enqueue(object : Callback<ProductData> {
            override fun onResponse(call: Call<ProductData>, response: Response<ProductData>) {
                if (response.isSuccessful) {
                    val body = response.body()
                }
            }

            override fun onFailure(call: Call<ProductData>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    return productList
    }
    }
