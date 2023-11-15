package com.example.ranas_first_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class ListFragment : Fragment(R.layout.fragment_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)

        val productsApi = RetrofitClient.getInstance().create(ProductApi::class.java)


        lifecycleScope.launch {
            val result = productsApi.getProducts(categoryId = 53, page = 1, channelId = 2)

            val list = result.body()?.data

            list?.let {
                recyclerView.adapter = ProductsAdapter(it)
            }

        }



    }

}