package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.e_commerce.models.ProductData
import com.example.e_commerce.repository.ProductRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ProductRepository) : ViewModel() {

    val productList get() = repository.productList

    init {

        GlobalScope.launch {
            repository.getAllProduct()
        }

    }

}
