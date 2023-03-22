package com.aek.artbook.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aek.artbook.data.base.ErrorModel

abstract class BaseViewModel : ViewModel() {

    protected val _loadingLiveData = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean>
        get() = _loadingLiveData

    protected val _errorLiveData = MutableLiveData<ErrorModel?>()
    val errorLiveData: LiveData<ErrorModel?>
        get() = _errorLiveData
}
