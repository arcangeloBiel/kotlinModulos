package com.example.abastecimento.presentation.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.abastecimento.R

class ListaItensAbastecimentoFragment : Fragment() {

    companion object {
        fun newInstance() = ListaItensAbastecimentoFragment()
    }

    private lateinit var viewModel: ListaItensAbastecimentoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.lista_itens_abastecimento_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListaItensAbastecimentoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}