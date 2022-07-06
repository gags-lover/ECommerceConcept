package com.github.astat1cc.sergeybalakintesttask.featuremap.presentation.fragments.map.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.LatLng

class MapViewModel : ViewModel() {

    private val _userPosition = MutableLiveData<LatLng>()
    val userPosition: LiveData<LatLng> = _userPosition

    fun setUserPosition(position: LatLng) {
        _userPosition.postValue(position)
    }
}