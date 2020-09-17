package com.manjee.mooda_copy.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.manjee.mooda_copy.R
import com.manjee.mooda_copy.databinding.FragmentAddStampBinding
import com.manjee.mooda_copy.viewmodel.AddStampViewModel

class AddStampFragment(var emotion: String) : Fragment() {

    private lateinit var binding: FragmentAddStampBinding
    private val viewModel: AddStampViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_stamp, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this@AddStampFragment
        return binding.root
    }
}