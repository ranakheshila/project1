package com.example.ranas_first_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.coroutines.launch

class ItemFragment : Fragment(R.layout.fragment_item) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      val productId =  arguments?.getInt("productId")

        val itemName= view.findViewById<TextView>(R.id.itemName)
        val itemDescription= view.findViewById<TextView>(R.id.itemDescription)
        val itemPrice= view.findViewById<TextView>(R.id.itemPrice)
        val imageItem= view.findViewById<ImageView>(R.id.itemImage)



        val productsApi = RetrofitClient.getInstance().create(ProductApi::class.java)


        lifecycleScope.launch {
            val result = productId?.let { productsApi.getItem(it) }

            val item = result?.body()?.data

            itemName.text=item?.name
            itemDescription.text=item?.description
            itemPrice.text=item?.final_pr
            Glide.with(requireContext()).load(item?.base_image?.large_image_url).into(imageItem)






        }



    }

}