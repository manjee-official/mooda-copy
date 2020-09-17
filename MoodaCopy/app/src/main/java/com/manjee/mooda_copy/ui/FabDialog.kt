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
import com.manjee.mooda_copy.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.dialog_fab.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class FabDialog(val mainViewModel: MainViewModel) : BottomSheetDialogFragment() {

    private lateinit var binding: DialogFabBinding
    private val viewModel: FabDialogViewModel by viewModels()

    private val dateTime: LocalDateTime = LocalDateTime.now()

    private var fabList: ArrayList<View> = ArrayList()
    private lateinit var mainFabOpen: Animation
    private lateinit var mainFabRotate: Animation

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FabDialogTheme)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        subscribeUi()
    }

    private fun init() {
        dateTime.format(DateTimeFormatter.ofPattern("MMM yyyy"))

        fabList.add(fabChild)
        fabList.add(fabFace)
        fabList.add(fabFavorite)
        fabList.add(fabMood)
        fabList.add(fabMoodBad)
        fabList.add(fabSmile)

        mainFabOpen = AnimationUtils.loadAnimation(context, R.anim.fab_open)
        mainFabRotate = AnimationUtils.loadAnimation(context, R.anim.fab_rotate)

        startFabAnimation()
    }

    private fun subscribeUi() {
        with(viewModel) {
            toggleFab.observe(this@FabDialog, Observer {
                dismiss()
            })

            clickEmotion.observe(this@FabDialog, Observer {
                dismiss()
                mainViewModel.setSelectEmotion(it)
            })
        }
    }

    private fun startFabAnimation() {
        tvDescription.animate().setStartDelay(200).setDuration(1000).alpha(1F).withEndAction {
            fabInit.animate().rotation(45f).setDuration(500).withStartAction {
                for (fab in fabList) {
                    fab.startAnimation(mainFabOpen)
                }
            }
        }.withStartAction {
            fabInit.visibility = View.VISIBLE
        }
    }
}