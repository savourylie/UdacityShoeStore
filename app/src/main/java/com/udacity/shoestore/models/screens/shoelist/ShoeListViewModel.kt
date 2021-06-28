package com.udacity.shoestore.models.screens.shoelist

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class ShoeListViewModel: ViewModel() {
    init {
        Timber.i("ShoeListViewModel created!")
    }

    var currentShoe = MutableLiveData<String>()
    var shoeList = mutableListOf<String>()

    override fun onCleared() {
        super.onCleared()
        Timber.i("ShoeListViewModel destroyed!")
    }
}