package com.example.ranas_first_project

data class ProductResponse(
    val data:List<Data>
)

data class Data(
    val id: Int,
    val name: String,
    val final_pr: String,
    val base_image: BaseImage,

)

data class BaseImage(
    val large_image_url:String,
)