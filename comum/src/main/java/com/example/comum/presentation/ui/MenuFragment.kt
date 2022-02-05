package com.example.comum.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.comum.R
import com.example.comum.databinding.LoginFragmentBinding
import com.example.comum.databinding.MenuFragmentBinding

class MenuFragment : Fragment() {

    companion object {
        fun newInstance() = MenuFragment()
    }

    private var _binding: MenuFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MenuViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      //  return inflater.inflate(R.layout.menu_fragment, container, false)
        _binding = MenuFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // viewModel = ViewModelProvider(this).get(MenuViewModel::class.java)

        // TODO: Use the ViewModel
        binding.cardPicking.setOnClickListener {
          val action = MenuFragmentDirections.actionMenuFragmentToDispositivosFragment()
            findNavController().navigate(action)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}