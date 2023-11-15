package com.example.ranas_first_project


data class ResponseItem(
    val data:DataItem,
)

data class DataItem(
    val name: String,
    val final_pr: String,
    val base_image: BaseImageItem,
    val description: String,

    )

data class BaseImageItem(
    val large_image_url:String,
)