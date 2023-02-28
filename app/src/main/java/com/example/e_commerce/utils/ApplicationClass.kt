package com.example.e_commerce.utils

import android.app.Application
import com.example.e_commerce.api.ApiService
import com.example.e_commerce.api.RetrofitHelper
import com.example.e_commerce.repository.ProductRepository


class ApplicationClass : Application() {
    lateinit var productRepository: ProductRepository
    override fun onCreate() {
        super.onCreate()
        Initialization()

    }

    fun Initialization() {
        val productapi = RetrofitHelper.getInstance().create(ApiService::class.java)

        productRepository = ProductRepository(productapi, applicationContext)

    }

}