package com.example.comum.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.comum.data.model.Dispositivos
import com.example.comum.databinding.DispositivosFragmentBinding
import com.example.comum.presentation.adapter.DispositivoAdapter

class DispositivosFragment : Fragment() {

    companion object {
        fun newInstance() = DispositivosFragment()
    }

    private var _binding: DispositivosFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: DispositivosViewModel

    private lateinit var dispositivoAdapter: DispositivoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       // return inflater.inflate(R.layout.dispositivos_fragment, container, false)
        _binding = DispositivosFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      //  viewModel = ViewModelProvider(this).get(DispositivosViewModel::class.java)
        // TODO: Use the ViewModel

        listaDispositivo()

    }
  fun listaDispositivo() {
      var item: MutableList<Dispositivos> = mutableListOf( Dispositivos(
          id = 1,
          status = "ativo",
          nome = "RFd01"
      ),
          Dispositivos(
              id = 2,
              status = "inativo",
              nome = "RFd02"
          ),

          Dispositivos(
              id = 3,
              status = "inativo",
              nome = "RFd03"
          ),

          )
      dispositivoAdapter = DispositivoAdapter(item)

      binding.recyclerView.apply {
          adapter = dispositivoAdapter
          layoutManager = LinearLayoutManager(activity)
      }

      dispositivoAdapter.notifyDataSetChanged()
  }

}