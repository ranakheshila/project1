package com.example.ranas_first_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class ProductsAdapter(private val dataSet: List<Data>) :
    RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val apiName: TextView
        val apiPrice: TextView
        val apiImage: ImageView
        val rootView: View

        init {
            // Define click listener for the ViewHolder's View
            apiName = view.findViewById<TextView>(R.id.ProductName)
            apiPrice = view.findViewById<TextView>(R.id.productPrice)
            apiImage = view.findViewById<ImageView>(R.id.ProductImage)
            rootView = view.findViewById<View>(R.id.rootView)

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.recyclerview, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.apiName.text = dataSet[position].name
        viewHolder.apiPrice.text = dataSet[position].final_pr
        Glide.with(viewHolder.apiName.context).load(dataSet[position].base_image.large_image_url)
            .into(viewHolder.apiImage)

        viewHolder.rootView.setOnClickListener {
            val bundle = Bundle()

            bundle.putInt("productId", dataSet[position].id)

            viewHolder.rootView.findNavController()
                .navigate(R.id.action_FirstFragment_to_SecondFragment,bundle)

        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}