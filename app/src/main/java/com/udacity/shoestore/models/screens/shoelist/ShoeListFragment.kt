package com.udacity.shoestore.models.screens.shoelist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.models.screens.instruction.InstructionFragmentDirections
import kotlinx.android.synthetic.main.shoe_item.view.*
import timber.log.Timber

class ShoeListFragment: Fragment() {

    private lateinit var shoeListViewModel: ShoeListViewModel
    private lateinit var binding: ShoeListFragmentBinding
    private lateinit var shoeItemBinding: ShoeItemBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        Log.i("ShoeListView", "onCreateView called!")

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.shoe_list_fragment,
            container,
            false
        )

        Timber.i("Called ViewModelProvider")
        shoeListViewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)

        binding.shoeListViewModel = shoeListViewModel
        binding.setLifecycleOwner(this)

        binding.addShoeFab.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }

        showShoes(inflater, container)

        return binding.root
    }

    private fun showShoes(inflater: LayoutInflater, container: ViewGroup?) {
        Log.i("ShoeListView", "showShoes called!")

        shoeListViewModel.shoeList.forEach { Log.i("ShoeListView", it) }

//        for (shoe_detail in viewModel.shoeList) {
//            Log.i("ShoeListView", "In for loop: ${shoe_detail}")
//
//            shoeItemBinding = DataBindingUtil.inflate(
//                inflater,
//                R.layout.shoe_item,
//                container,
//                false
//            )
//
//            shoeItemBinding.root.shoe_list_item.text = shoe_detail
//            binding.shoeScrollLinearLayout.addView(shoeItemBinding.root)
//
//        }
    }
}