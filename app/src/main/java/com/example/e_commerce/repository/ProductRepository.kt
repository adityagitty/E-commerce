package com.example.e_commerce.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.e_commerce.api.ApiService
import com.example.e_commerce.models.ProductData
import com.example.e_commerce.utils.NetworkUtils


class ProductRepository(
    private val apiService: ApiService,
    val context: Context
) {
    private val _productList = MutableLiveData<List<ProductData>>()
    val productList: LiveData<List<ProductData>>
        get() = _productList

    suspend fun getAllProduct() {
        if (NetworkUtils.isOnline(context)) {
            //get data from api server
            Log.d("InternetConnection", "You Are Online")
            val result = apiService.getAllProduct()
            if (result?.body() != null) {
                _productList.postValue(result.body())

                //this line i used to set data into news live data from interface.
            }
        }
    }
}