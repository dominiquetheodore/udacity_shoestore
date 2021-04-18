package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar
import com.udacity.shoestore.models.Shoe

class ShoeStoreViewModel: ViewModel() {
    private var _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoeList : LiveData<MutableList<Shoe>>
        get() = _shoes

    private val _isShoeAdded = MutableLiveData<Boolean>()
    val isShoeAdded: LiveData<Boolean>
        get() = _isShoeAdded

    var shoe = MutableLiveData<Shoe>()
    var name = MutableLiveData<String>()

    private var shoeInventoryList: MutableList<Shoe> = mutableListOf(
            Shoe(
                    "Chuck Taylor All-Stars", 10.5,
                    "Converse", "Chuck Taylor All-Stars or Converse All Stars (also referred to as \"Converse\", \"Chuck Taylors\", \"Chucks\", \"Cons\", and \"All Stars\") is a model of casual shoe manufactured by Converse (a subsidiary of Nike, Inc. since 2003) that was initially developed as a basketball shoe in the early 20th century. The design of the Chuck Taylor " +
                    "All Star has remained largely unchanged since its introduction in the 1920s. "
            ),
            Shoe(
                    "Nike Air Max", 11.5,
                    "Nike", "Nike Air Max is a line of shoes produced by Nike, Inc., with the first model released in 1987. Air Max shoes are identified by their midsoles incorporating flexible urethane pouches filled with pressurized gas, visible from the exterior of the shoe and intended to provide cushioning underfoot. Air Max " +
                    "was conceptualized by Tinker Hatfield, who initially worked for Nike designing stores."
            ),
            Shoe(
                    "Stan Smith", 11.5,
                    "Adidas", "Adidas Stan Smith is a tennis shoe made by Adidas, and first launched in 1965. Originally named \"Adidas Robert Haillet\" after the brand endorsed French prominent player Robert Haillet, in 1978 the sneakers were renamed after Stan Smith, an American tennis " +
                    "player who was active between the end of the 1960s and the beginning of the 1980s."
            )
    )

    init {
        _isShoeAdded.value = false
        _shoes.value = shoeInventoryList
        shoe.value = Shoe("",0.0,"", "")
    }

    public fun addShoe(shoe: Shoe?) {
        if (shoe != null) {
            Log.i("addShoe", "adding to list " + shoe.name)
            Log.i("addShoe", "length before " + shoeInventoryList.size)
            shoeInventoryList.add(shoe)
            Log.i("addShoe", "length after " + shoeInventoryList.size)
            Log.i("addShoe", "list is " + shoeInventoryList)
            _shoes.value = shoeInventoryList
            _isShoeAdded.value = true

        }
    }

    /*
    private lateinit var shoeList : MutableList<Shoe>

    init {
        initializeShoes()
    }


    */

}