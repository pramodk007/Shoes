package com.androiddev.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.androiddev.constant.Constants
import com.androiddev.shoes.R
import com.google.android.material.imageview.ShapeableImageView

class ShoeDisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shoe_display)

        //linking the views
        val shoe_image: ImageView = findViewById(R.id.img_ShoeImage)
        val shoe_title: TextView = findViewById(R.id.shoe_title)
        val shoe_description: TextView = findViewById(R.id.txt_shoePrice)

        //extracting the data from the intent
        val bundle :Bundle? = intent.extras
        val shoeImage = bundle!!.getInt(Constants.IMAGE)
        val shoeTitle = bundle.getString(Constants.TITLE)
        val shoeDescription = bundle.getString(Constants.PRICE)

        //providing the data to views
        shoe_image.setImageResource(shoeImage)
        shoe_title.text = shoeTitle
        shoe_description.text = shoeDescription
    }
}