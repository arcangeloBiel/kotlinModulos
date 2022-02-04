package com.example.comum.presentation.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.comum.R

class DispositivosFragment : Fragment() {

    companion object {
        fun newInstance() = DispositivosFragment()
    }

    private lateinit var viewModel: DispositivosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dispositivos_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DispositivosViewModel::class.java)
        // TODO: Use the ViewModel
    }

}