package com.example.mvvmcountrylist.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmcountrylist.R
import com.example.mvvmcountrylist.adapter.CountryAdapter
import com.example.mvvmcountrylist.databinding.FragmentCountryListBinding
import com.example.mvvmcountrylist.viewmodels.CountryListViewModel

class CountryListFragment : Fragment() {
    private var _binding: FragmentCountryListBinding? = null
    private lateinit var viewModel: CountryListViewModel
    private val countryAdapter = CountryAdapter(arrayListOf())
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCountryListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(CountryListViewModel::class.java)
        viewModel.refreshData()
        binding.recyclerViewCountry.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewCountry.adapter = countryAdapter


        /*  move_to_detail.setOnClickListener{
            val action = CountryListFragmentDirections.actionCountryListFragmentToCountryDetailFragment()
            Navigation.findNavController(it).navigate(action)

        }*/
            obseveLiveData()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun obseveLiveData(){
        viewModel.countries.observe(viewLifecycleOwner, Observer{ countries ->
            countries?.let{
                binding.recyclerViewCountry.visibility=View.VISIBLE
                countryAdapter.updateCountryList(countries)
            }

        })
        viewModel.coutryError.observe(viewLifecycleOwner,Observer{ error ->

            error?.let{
                if(it){
                binding.countryError.visibility=View.VISIBLE
                }
                else {
                    binding.countryError.visibility=View.GONE
                }

            }

        })
        viewModel.countryLoading.observe(viewLifecycleOwner,Observer{ loading ->
            
            loading?.let {
                if(it){
                    binding.countryLoading.visibility=View.VISIBLE
                    
                }
                else {
                    binding.countryLoading.visibility=View.GONE}
                
            }
            
        })
    }



}