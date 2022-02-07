package com.example.comum.presentation.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.comum.R
import com.example.comum.data.model.Dispositivos
import com.example.comum.data.model.MenuModel
import com.example.comum.databinding.MenuFragmentBinding
import com.example.comum.presentation.adapter.DispositivoAdapter
import com.example.comum.presentation.adapter.MenuAdapter

class MenuFragment : Fragment() {

    companion object {
        fun newInstance() = MenuFragment()
    }

    private var _binding: MenuFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MenuViewModel

    private lateinit var menuAdapter: MenuAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      //  return inflater.inflate(R.layout.menu_fragment, container, false)
        _binding = MenuFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listaMenu()

    }
    fun listaMenu() {
        var item: MutableList<MenuModel> =  mutableListOf( MenuModel(1,"Picking",  R.drawable.menu_logo_picking), MenuModel(2,"Abastecimento",  R.drawable.menu_logo_abastecimento),)
        menuAdapter = MenuAdapter(item)

        binding.menuList.apply {
            adapter = menuAdapter
            layoutManager = LinearLayoutManager(activity)
        }

        menuAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}