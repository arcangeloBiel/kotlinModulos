package com.example.abastecimento.presentation.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.abastecimento.R

class MenuAbastecimentoFragment : Fragment() {

    companion object {
        fun newInstance() = MenuAbastecimentoFragment()
    }

    private lateinit var viewModel: MenuAbastecimentoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.menu_abastecimento_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MenuAbastecimentoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}