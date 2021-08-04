package com.example.mvvmcountrylist.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmcountrylist.R
import com.example.mvvmcountrylist.databinding.FragmentCountryDetailBinding
import com.example.mvvmcountrylist.view.CountryDetailFragmentArgs
import com.example.mvvmcountrylist.viewmodels.CountryDetailViewModel


class CountryDetailFragment : Fragment() {
    private var _binding: FragmentCountryDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel : CountryDetailViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCountryDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
        // Inflate the layout for this fragment

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel = ViewModelProviders.of(this).get(CountryDetailViewModel::class.java)
        viewModel.getData()

        obseveLiveData()



        arguments?.let{
           val countryId = CountryDetailFragmentArgs.fromBundle(it)

        }


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun obseveLiveData() {
        viewModel.country.observe(viewLifecycleOwner, Observer{ country ->
            country?.let{
                binding.CountryName.text = country.name
                binding.CapitalText.text = country.capital
                binding.CurrencyText.text = country.currency
                binding.LanguageText.text = country.language

            }

        })
    }

}