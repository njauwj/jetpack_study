package com.wj.livedata2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var inflate = inflater.inflate(R.layout.fragment_first, container, false)
        var seekBar = inflate.findViewById<SeekBar>(R.id.seekBar)
        var viewModelProvider = activity?.let {
            ViewModelProvider(
                it, ViewModelProvider.AndroidViewModelFactory(it.application)
            )
        }
        var myViewModel = viewModelProvider?.get<MyViewModel>(MyViewModel::class.java)
        //myViewModel.process.value 相当于 it
        myViewModel?.process?.observe(requireActivity()) {
            seekBar.progress = it
        }
        seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                myViewModel?.process?.value = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        return inflate
    }

}