package com.example.lovecolculator

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovecolculator.remote.LoveModel
import com.example.lovecolculator.remote.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(
    private var repository: Repository
    ) : ViewModel() {

    fun getLiveData(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getData(firstName, secondName)
    }

}