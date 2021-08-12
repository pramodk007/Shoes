package com.androiddev.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androiddev.adapter.ShoeAdapter
import com.androiddev.constant.Constants
import com.androiddev.data.Shoe
import com.androiddev.shoes.R
import java.util.ArrayList

class ShoesActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var shoeAdapter: ShoeAdapter
    private lateinit var shoeList: ArrayList<Shoe>
    private lateinit var shoeImage:Array<Int>
    private lateinit var shoeTitle:Array<String>
    private lateinit var shoePrice: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initializing array list
        shoeList = arrayListOf<Shoe>()

        //adding data to list
        addShoesToList()

        //initializing array adapter
        shoeAdapter = ShoeAdapter(shoeList)

        //initializing recyclerView
        recyclerView = findViewById(R.id.rv_shoeList)
        recyclerView.layoutManager = GridLayoutManager(this,2)
        recyclerView.setHasFixedSize(true)

        //sending data to next activity onClick
        sendShoeData()

    }

    private fun addShoesToList() {
        //array of image
        shoeImage = arrayOf(
            R.drawable.shoea,
            R.drawable.shoeb,
            R.drawable.shoec,
            R.drawable.shoed,
            R.drawable.shoee,
            R.drawable.shoef,
            R.drawable.shoeg,
            R.drawable.shoeh,
            R.drawable.shoei,
            R.drawable.shoej,
            R.drawable.shoek,
            R.drawable.shoel,
            R.drawable.shoem,
            R.drawable.shoen,
            R.drawable.shoeo,
            R.drawable.shoep,
            R.drawable.shoeq,
            R.drawable.shoer,
            R.drawable.shoes,
            R.drawable.shoet,
        )
        //array of title
        shoeTitle = arrayOf(
            getString(R.string.shoe_one),
            getString(R.string.shoe_two),
            getString(R.string.shoe_three),
            getString(R.string.shoe_four),
            getString(R.string.shoe_five),
            getString(R.string.shoe_six),
            getString(R.string.shoe_seven),
            getString(R.string.shoe_eight),
            getString(R.string.shoe_nine),
            getString(R.string.shoe_ten),
            getString(R.string.shoe_eleven),
            getString(R.string.shoe_twelve),
            getString(R.string.shoe_thirteen),
            getString(R.string.shoe_fourteen),
            getString(R.string.shoe_fifteenth),
            getString(R.string.shoe_sixteen),
            getString(R.string.shoe_seventeen),
            getString(R.string.shoe_eighteen),
            getString(R.string.shoe_nineteen),
            getString(R.string.shoe_twenty)
        )
        //array of Product productPrice
        shoePrice = arrayOf(
            getString(R.string.shoePrice_one),
            getString(R.string.shoePrice_two),
            getString(R.string.shoePrice_three),
            getString(R.string.shoePrice_four),
            getString(R.string.shoePrice_five),
            getString(R.string.shoePrice_six),
            getString(R.string.shoePrice_seven),
            getString(R.string.shoePrice_eight),
            getString(R.string.shoePrice_nine),
            getString(R.string.shoePrice_ten),
            getString(R.string.shoePrice_eleven),
            getString(R.string.shoePrice_twelve),
            getString(R.string.shoePrice_thirteen),
            getString(R.string.shoePrice_fourteen),
            getString(R.string.shoePrice_fifteenth),
            getString(R.string.shoePrice_sixteen),
            getString(R.string.shoePrice_seventeen),
            getString(R.string.shoePrice_eighteen),
            getString(R.string.shoePrice_nineteen),
            getString(R.string.shoePrice_twenty)
        )
        //adding the data to the Data class
        for(i in shoeImage.indices){
            val product = Shoe(shoeImage[i],shoeTitle[i],shoePrice[i])
            shoeList.add(product)
        }

    }
    private fun sendShoeData() {

        val adapter = ShoeAdapter(shoeList)
        recyclerView.adapter =adapter
        adapter.onProductClickListener(object :ShoeAdapter.onProductClickListener{
            override fun onProductClick(position: Int) {
                val intent = Intent(this@ShoesActivity,ShoeDisplayActivity::class.java)
                intent.putExtra(Constants.TITLE,shoeList[position].shoeTitle)
                intent.putExtra(Constants.IMAGE,shoeList[position].shoeImage)
                intent.putExtra(Constants.PRICE,shoeList[position].shoePrice)
                startActivity(intent)
            }

        })
    }
}

