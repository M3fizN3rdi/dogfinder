package com.groegcodedev.dog.ui.gridfinder.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.groegcodedev.dog.data.repository.GridDogsRepository
import com.groegcodedev.dog.ui.home.viewmodel.ImageClass
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GridDogsViewModel(private val repository: GridDogsRepository = GridDogsRepository()) : ViewModel() {
    private val _data = MutableLiveData<StateGridViewModel>()
    private val data: LiveData<StateGridViewModel> = _data

    private val _selectedImageUrl = MutableLiveData<String?>()
    private val selectedImageUrl: LiveData<String?> = _selectedImageUrl

    fun getGridDogs() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getGridDogs()
            if (response.isSuccessful) {
                response.body()?.let {
                    _data.postValue(StateGridViewModel.Sucess(it))
                } ?: _data.postValue(StateGridViewModel.Error("No data"))
            } else {
                _data.postValue(StateGridViewModel.Error("Service error"))
            }
        }
    }

    fun getData(): LiveData<StateGridViewModel> {
        return this.data
    }

    fun getImage(): LiveData<String?> {
        return this.selectedImageUrl
    }

    fun onImageClicked(imageUrl: String) {
        _selectedImageUrl.value = imageUrl
        ImageClass.imageGrid = imageUrl
    }
}