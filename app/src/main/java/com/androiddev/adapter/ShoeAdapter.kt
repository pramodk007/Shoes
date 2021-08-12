package com.androiddev.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.androiddev.data.Shoe
import com.androiddev.shoes.R
import com.google.android.material.imageview.ShapeableImageView

class ShoeAdapter(private val productList: ArrayList<Shoe>): RecyclerView.Adapter<ShoeAdapter.ProductViewHolder>() {

    private lateinit var mListner:onProductClickListener

    interface  onProductClickListener{
        fun onProductClick(position: Int)
    }

    fun onProductClickListener(listener: onProductClickListener){
        mListner = listener
    }

    class ProductViewHolder(itemView: View, listener: onProductClickListener) : RecyclerView.ViewHolder(itemView){
        var product_title: TextView = itemView.findViewById(R.id.product_title)
        val product_image: ShapeableImageView = itemView.findViewById(R.id.product_image)
        val product_price: TextView = itemView.findViewById(R.id.product_Price)
        init {
            itemView.setOnClickListener {
                listener.onProductClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.single_product_row,parent,false)
        return ProductViewHolder(itemView,mListner)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentItem = productList[position]
        holder.product_image.setImageResource(currentItem.shoeImage)
        holder.product_title.text = currentItem.shoeTitle
        holder.product_price.text = currentItem.shoePrice
    }

    override fun getItemCount(): Int {
        return productList.size
    }

}