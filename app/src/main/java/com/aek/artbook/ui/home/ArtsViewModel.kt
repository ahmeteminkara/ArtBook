package com.aek.artbook.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aek.artbook.data.repository.ArtRepository
import com.aek.artbook.data.model.ArtModel
import com.aek.artbook.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArtsViewModel @Inject constructor(
    private val repository: ArtRepository
) : BaseViewModel() {

    private val _artsLiveData = MutableLiveData<List<ArtModel>>()
    val artsLiveData: LiveData<List<ArtModel>>
        get() = _artsLiveData

    fun getSavedArtList() = viewModelScope.launch {
        val list = repository.getSavedArts()
        _artsLiveData.value = list
    }

    fun deleteArt(art: ArtModel) = viewModelScope.launch {
        repository.deleteArt(art)
        getSavedArtList()
    }
}
