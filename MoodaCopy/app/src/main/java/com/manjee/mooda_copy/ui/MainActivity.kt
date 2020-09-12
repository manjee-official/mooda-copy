package com.manjee.mooda_copy.ui

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.manjee.mooda_copy.R
import com.manjee.mooda_copy.databinding.ActivityMainBinding
import com.manjee.mooda_copy.util.CommonUtil
import com.manjee.mooda_copy.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    private val fabDialog = FabDialog()

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this@MainActivity

        binding.testBtn.setOnClickListener {
            fabDialog.show(supportFragmentManager, "")
        }
    }

    private fun subscribeUi() {
        with(viewModel) {

        }
    }
}