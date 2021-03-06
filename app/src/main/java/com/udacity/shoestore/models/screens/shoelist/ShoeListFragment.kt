package com.udacity.shoestore.models.screens.shoelist

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import kotlinx.android.synthetic.main.shoe_item.view.*
import timber.log.Timber


class ShoeListFragment: Fragment() {

    private val shoeListViewModel: ShoeListViewModel by activityViewModels()
    private lateinit var binding: ShoeListFragmentBinding
    private lateinit var shoeItemBinding: ShoeItemBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        Log.i("ShoeListView", "onCreateView called!")
        (requireActivity() as AppCompatActivity).supportActionBar?.show()

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.shoe_list_fragment,
            container,
            false
        )

        Timber.i("Called ViewModelProvider")
//        shoeListViewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)

        binding.shoeListViewModel = shoeListViewModel
        binding.setLifecycleOwner(this)

        binding.addShoeFab.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }

        setHasOptionsMenu(true)
        showShoes(inflater, container)

        shoeListViewModel.logoutFlag.observe(viewLifecycleOwner, Observer { isFinished ->
            if (isFinished) {
                val action = ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment()
                NavHostFragment.findNavController(this).navigate(action)
                shoeListViewModel.onLogoutComplete()
            }
        })

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.shoe_list_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        logout()

        return NavigationUI.onNavDestinationSelected(item!!, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun logout() {
        findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
    }

    private fun showShoes(inflater: LayoutInflater, container: ViewGroup?) {
        Log.i("ShoeListView", "showShoes called!")

        shoeListViewModel.shoeList.forEach { Log.i("ShoeListView", it) }

        for (shoe_detail in shoeListViewModel.shoeList) {
            Log.i("ShoeListView", "In for loop: ${shoe_detail}")

            shoeItemBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.shoe_item,
                container,
                false
            )

            shoeItemBinding.shoeItem = shoe_detail
            binding.shoeScrollLinearLayout.addView(shoeItemBinding.root)
//
        }
    }


}