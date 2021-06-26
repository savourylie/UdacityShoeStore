package com.udacity.shoestore.models.screens.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class LoginViewModel: ViewModel() {
    init {
        Timber.i("LoginViewModel created!")
    }

    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()


}