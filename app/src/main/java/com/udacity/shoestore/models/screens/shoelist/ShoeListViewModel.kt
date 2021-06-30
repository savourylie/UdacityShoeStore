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
    var logoutFlag = MutableLiveData<Boolean>()

    fun createNewShoes(): MutableLiveData<String> {
        return MutableLiveData<String>()
    }

    fun logout() {
        logoutFlag.value = true
    }

    fun onLogoutComplete() {
        logoutFlag.value = false
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("ShoeListViewModel destroyed!")
    }
}