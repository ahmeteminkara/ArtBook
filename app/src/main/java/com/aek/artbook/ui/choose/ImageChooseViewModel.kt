package com.aek.artbook.ui.choose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aek.artbook.data.base.ErrorModel
import com.aek.artbook.data.model.ImageResponse
import com.aek.artbook.data.repository.ArtRepository
import com.aek.artbook.ui.base.BaseViewModel
import com.aek.artbook.constants.AppConstants
import com.aek.artbook.extentions.handleResourceNotNullData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageChooseViewModel @Inject constructor(
    private val repository: ArtRepository
) : BaseViewModel() {

    private val _searchLiveData = MutableLiveData<ImageResponse>()
    val searchLiveData: LiveData<ImageResponse>
        get() = _searchLiveData

    fun searchQuery(query: String) {
        if (query.isEmpty()) return
        viewModelScope.launch {
            try {
                repository.searchImage(query).collect {
                    it.handleResourceNotNullData(
                        onSuccess = { response ->
                            _searchLiveData.value = response
                        },
                        onError = { errorModel ->
                            _errorLiveData.value = errorModel
                        },
                        onLoading = { isLoading ->
                            _loadingLiveData.value = isLoading
                        }
                    )
                }
            } catch (ex: Exception) {
                _errorLiveData.value = ErrorModel(
                    AppConstants.ErrorMessage.ERROR_MESSAGE_UNKNOWN,
                    500
                )
            }
        }
    }
}
