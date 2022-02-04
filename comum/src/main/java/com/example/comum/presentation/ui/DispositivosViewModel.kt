package com.example.comum.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.comum.data.model.Dispositivos

class DispositivosViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private val _listPost = MutableLiveData<MutableList<Dispositivos>>()
    val listPost: LiveData<MutableList<Dispositivos>>
        get() = _listPost
    init {
     //   fetchPosts()
    }
}