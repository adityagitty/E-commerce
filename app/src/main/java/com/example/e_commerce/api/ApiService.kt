package com.example.e_commerce.api


import com.example.e_commerce.models.ProductData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("products")
    fun getAllProduct(@Query("categories") categories: String?) : Call<ProductData>



}