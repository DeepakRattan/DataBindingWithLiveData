package com.example.databindingwithlivedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*

// To make the example simple ,we are using a fake repository providing list of fruits.
object FakeRepository {

    private val fruitNames: List<String> =
        listOf("Apple", "Banana", "Orange", "Grapes", "Kiwi", "Fig", "Pear", "Strawberry")


    private val _currentRandomFruitName = MutableLiveData<String>()
    val currentRandomFruitName: LiveData<String>
        // get is getter that will return _currentRandomFruitName
        get() = _currentRandomFruitName

    // It is like a constructor.It will called automatically when we create object of FakeRepository
    init {
        //Setting the first value i.e apple to mutableLiveData
        _currentRandomFruitName.value = fruitNames.first()
    }

    fun getRandomFruitName(): String {
        val random = Random()
        return fruitNames[random.nextInt(fruitNames.size)]
    }

    fun changeCurrentRandomFruitName() {
        _currentRandomFruitName.value = getRandomFruitName()
    }


}