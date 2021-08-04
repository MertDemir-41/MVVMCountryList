package com.example.mvvmcountrylist.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmcountrylist.model.Country

class CountryListViewModel : ViewModel() {
    val countries = MutableLiveData<List<Country>>()
    val coutryError = MutableLiveData<Boolean>()
    val countryLoading = MutableLiveData<Boolean>()

    fun refreshData(){

        val country = Country("Ankara","tl","wwww.ss.com","Türkçe","Türkiye","Asya")
        val country2 = Country("Berlin","Euro","wwww.ss.com","Dustch","Almanya","Avrupa")
        val country3 = Country("Washington","Dolar","wwww.ss.com","English","America","Amerika")

        val countrylist =arrayListOf<Country>(country,country2,country3)
        countries.value= countrylist
        coutryError.value=false
        countryLoading.value=false


    }

}