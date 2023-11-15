package com.example.ranas_first_project

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ProductApi {


    @GET("products")
    suspend fun getProducts(
        @Query("category_id") categoryId: Int,
        @Query("page") page: Int,
        @Query("channel_id") channelId: Int
    ): Response<ProductResponse>

    @GET("products/get")
    suspend fun getItem(
        @Query("product_id") productId: Int
    ) : Response<ResponseItem>



}