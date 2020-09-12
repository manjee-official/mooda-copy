package com.manjee.mooda_copy.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.manjee.mooda_copy.R
import com.manjee.mooda_copy.databinding.DialogFabBinding
import com.manjee.mooda_copy.viewmodel.FabDialogViewModel
import kotlinx.android.synthetic.main.dialog_fab.*

class FabDialog : BottomSheetDialogFragment() {

    private lateinit var binding: DialogFabBinding
    private val viewModel: FabDialogViewModel by viewModels()

    private var fabList: ArrayList<View> = ArrayList()

    private var isFabOpen = false
    private lateinit var mainFabOpen: Animation
    private lateinit var mainFabClose: Animation
    private lateinit var mainFabRotate: Animation
    private lateinit var mainFabReverseRotate: Animation

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_fab, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this@FabDialog
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        subscribeUi()
    }

    private fun init() {
        fabList.add(fabChild)
        fabList.add(fabFace)
        fabList.add(fabFavorite)
        fabList.add(fabMood)
        fabList.add(fabMoodBad)
        fabList.add(fabSmile)

        mainFabOpen = AnimationUtils.loadAnimation(context, R.anim.fab_open)
        mainFabClose = AnimationUtils.loadAnimation(context, R.anim.fab_close)
        mainFabRotate = AnimationUtils.loadAnimation(context, R.anim.fab_rotate)
        mainFabReverseRotate =
            AnimationUtils.loadAnimation(context, R.anim.fab_reverse_rotate)
    }

    private fun subscribeUi() {
        with(viewModel) {
            toggleFab.observe(this@FabDialog, Observer {
                openFabGroup()
            })
        }
    }

    private fun openFabGroup() {
        isFabOpen = if (isFabOpen) {
            startFabAnimation()
            false
        } else {
            startFabAnimation()
            true
        }
    }

    private fun startFabAnimation() {
        for (fab in fabList) {
            if (isFabOpen) {
                fabInit.startAnimation(mainFabReverseRotate)
                    .apply { fabInit.setImageResource(R.drawable.ic_add_white) }
                fab.startAnimation(mainFabClose)
            } else {
                fabInit.startAnimation(mainFabRotate)
                    .apply { fabInit.setImageResource(R.drawable.ic_close_white) }
                fab.startAnimation(mainFabOpen)
            }
        }
    }
}