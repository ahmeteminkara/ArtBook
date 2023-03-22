package com.aek.artbook.ui.form

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aek.artbook.data.base.ErrorModel
import com.aek.artbook.data.repository.ArtRepository
import com.aek.artbook.domain.ArtModel
import com.aek.artbook.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArtAddFormViewModel @Inject constructor(
    private val repository: ArtRepository
) : BaseViewModel() {

    private var selectedImagePath: String = ""

    private val _insertLiveData = MutableLiveData<Unit>()
    val insertLiveData: LiveData<Unit>
        get() = _insertLiveData

    fun setSelectedImagePath(path: String) {
        selectedImagePath = path
    }

    private fun makeArt(
        name: String,
        artistName: String,
        year: String
    ): ArtModel? {
        if (name.isEmpty() || artistName.isEmpty() || year.isEmpty() || selectedImagePath.isEmpty()) {
            _errorLiveData.value = ErrorModel("Enter name, artist name, year or select image", -1)
            return null
        }

        return ArtModel(name, artistName, year, selectedImagePath)
    }

    fun insertArt(name: String, artistName: String, year: String) {
        viewModelScope.launch {
            makeArt(name, artistName, year)?.let { art ->
                repository.insertArt(art)
                _insertLiveData.value = Unit
            }
        }
    }
}
