package com.example.databindingwithlivedata

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel : ViewModel() {

    /* currentRandomFruitName property inside our view model will respond to changes that happens to
        the repository's currentRandomFruitName */
    val currentRandomFruitName: LiveData<String>
        get() = FakeRepository.currentRandomFruitName

    // functions
    fun onChangeRandomFruitClick() = FakeRepository.changeCurrentRandomFruitName()

    //property for two way data binding
    @Bindable
    val editTextContent = MutableLiveData<String>()

    private val _displayedEditTextContent = MutableLiveData<String>()
    val displayedEditTextContent: LiveData<String>
        get() = _displayedEditTextContent

    fun onDisplayEditTextContentClick(){
        _displayedEditTextContent.value = editTextContent.value
    }

    fun onSelectRandomEditTextFruit(){
        editTextContent.value= FakeRepository.getRandomFruitName()
    }

}