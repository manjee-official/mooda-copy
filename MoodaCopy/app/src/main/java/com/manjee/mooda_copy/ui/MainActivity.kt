package com.manjee.mooda_copy.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import com.manjee.mooda_copy.R
import com.manjee.mooda_copy.databinding.ActivityMainBinding
import com.manjee.mooda_copy.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this@MainActivity

        subscribeUi()
    }

    private fun subscribeUi() {
        with(viewModel) {
            viewModel.toggleFab.observe(this@MainActivity) {
                FabDialog().show(supportFragmentManager, "")
            }
        }
    }
}