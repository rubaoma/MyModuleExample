package com.example.mymoduleexample1.viewmodel

import androidx.lifecycle.MutableLiveData

class MainViewModel: BaseViewModel() {

    val showAndroidJobsLiveData = MutableLiveData<Boolean>()
    val outAppLiveData = MutableLiveData<Boolean>()

    fun onShowAndroidJobsRequire(){
        showAndroidJobsLiveData.postValue(true)
    }

    fun onOutAppLiveData(){
        outAppLiveData.postValue(true)
    }
}