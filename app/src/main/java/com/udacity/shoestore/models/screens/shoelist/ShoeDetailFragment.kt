package com.udacity.shoestore.models.screens.shoelist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding

import timber.log.Timber

class ShoeDetailFragment: Fragment() {
    private lateinit var shoeListViewModel: ShoeListViewModel
    private lateinit var binding: ShoeDetailFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.shoe_detail_fragment,
            container,
            false
        )

        Timber.i("Called ViewModelProvider")
        shoeListViewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)

        binding.shoeListViewModel = shoeListViewModel
        binding.setLifecycleOwner(this)

        binding.addShoeButton.setOnClickListener {
            var currentShoe: String = binding.editTextEmailLogin.text.toString()
            Log.i("ShoeDetailView", "Currenst shoes detail: ${currentShoe}")

            shoeListViewModel.shoeList.add(currentShoe)
            shoeListViewModel.shoeList.forEach { Log.i("ShoeDetailView", it) }
//
            Toast.makeText(getActivity(), "We have added the shoes to your list!" , Toast.LENGTH_LONG).show();
            shoeListViewModel.currentShoe.value = ""
        }

        return binding.root
    }

}