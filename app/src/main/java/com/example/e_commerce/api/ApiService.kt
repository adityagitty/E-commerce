package com.example.e_commerce.api


import com.example.e_commerce.models.ProductData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET(ApiConstant.GET_ALL_PRODUCT)
    suspend fun getAllProduct(): Response<List<ProductData>>
//    @GET(ApiConstant.GET_JEWELERY)
//    suspend fun getJewelery():Response<List<ProductData>>
//    @GET(ApiConstant.GET_MENS_CLOTHING)
//    suspend fun getMensClothing():Response<List<ProductData>>
//    @GET(ApiConstant.GET_ELECTRONICS)
//    suspend fun getElectronics():Response<List<ProductData>>
//    @GET(ApiConstant.GET_WOMENS_CLOTHING)
//    suspend fun getWomensClothing():Response<List<ProductData>>
}