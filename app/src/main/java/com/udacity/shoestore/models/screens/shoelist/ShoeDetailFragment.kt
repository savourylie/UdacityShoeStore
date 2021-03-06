package com.udacity.shoestore.models.screens.shoelist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding

import timber.log.Timber

class ShoeDetailFragment: Fragment() {
    private val shoeListViewModel: ShoeListViewModel by activityViewModels()
    private lateinit var binding: ShoeDetailFragmentBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.shoe_detail_fragment,
            container,
            false
        )

        Timber.i("Called ViewModelProvider")
//        shoeListViewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)

        binding.currentShoe = shoeListViewModel.currentShoe.value
        binding.setLifecycleOwner(this)

        binding.addShoeButton.setOnClickListener {
            Log.i("ShoeDetailView", "Currenst shoes detail: ${binding.currentShoe}")

            shoeListViewModel.shoeList.add(binding.currentShoe ?: "")
            shoeListViewModel.shoeList.forEach { Log.i("ShoeDetailView", it) }
//
            Toast.makeText(getActivity(), "We have added the shoes to your list!" , Toast.LENGTH_SHORT).show();
            binding.currentShoe = ""
        }

        return binding.root
    }

}