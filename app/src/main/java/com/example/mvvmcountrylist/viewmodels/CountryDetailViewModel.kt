package com.example.mvvmcountrylist.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmcountrylist.model.Country

class CountryDetailViewModel : ViewModel() {
    val country = MutableLiveData<Country>()


    fun getData(){

        val country1 = Country("Ankara","TL","wwww.ss.com","Türkçe","Türkiye","Asya")

        country.value=country1

    }



}