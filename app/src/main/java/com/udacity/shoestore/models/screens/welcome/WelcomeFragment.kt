package com.udacity.shoestore.models.screens.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.WelcomeFragmentBinding
import com.udacity.shoestore.models.screens.welcome.WelcomeFragmentDirections
import timber.log.Timber

class WelcomeFragment : Fragment() {
    private lateinit var viewModel: WelcomeViewModel
    private lateinit var binding: WelcomeFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.welcome_fragment,
            container,
            false
        )

        Timber.i("Called ViewModelProvider")
        viewModel = ViewModelProvider(this).get(WelcomeViewModel::class.java)

        binding.welcomeViewModel = viewModel
        binding.setLifecycleOwner(this)

        binding.buttonWelcome.setOnClickListener {
            findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment())
        }

        return binding.root
    }

}