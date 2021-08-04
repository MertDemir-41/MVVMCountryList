package com.example.mvvmcountrylist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmcountrylist.databinding.CountryItemBinding
import com.example.mvvmcountrylist.databinding.FragmentCountryDetailBinding
import com.example.mvvmcountrylist.model.Country
import com.example.mvvmcountrylist.view.CountryListFragmentDirections


class CountryAdapter (private val CountryList : ArrayList<Country>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(val binding : CountryItemBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = CountryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return CountryViewHolder(binding)

    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.binding.CountryText.text = CountryList[position].name
        holder.binding.Region.text = CountryList[position].region

        holder.binding.layout.setOnClickListener{
            val action = CountryListFragmentDirections.actionCountryListFragmentToCountryDetailFragment()
            Navigation.findNavController(it).navigate(action)
        }

        }



    override fun getItemCount(): Int {

        return CountryList.count()

    }
    fun updateCountryList(newCountryList : List<Country>){

        CountryList.clear()
        CountryList.addAll(newCountryList)
        notifyDataSetChanged()

    }
}