package com.example.comum.presentation.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.comum.databinding.LoginFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginFragment : Fragment() {

    private var _binding: LoginFragmentBinding? = null
    private val binding get() = _binding!!

    private val loginViewModel: LoginViewModel  by viewModel()

    private var progressDialog: ProgressDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LoginFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configProgressDialog()
        autenticar()
        autenticacaoObserver()
        exceptionObserver()
        loadingObserver()

    }

    private fun configProgressDialog() {
        progressDialog = ProgressDialog(requireActivity())
        progressDialog?.setTitle("Carregando...")
        progressDialog?.setMessage("Aguarde a autenticação")
        progressDialog?.setCancelable(false)
    }

    private fun autenticar() {
        binding.buttonLogin.setOnClickListener {
            val codigo = binding.inputUsuario.editText?.text.toString()
            val senha = binding.inputSenha.editText?.text.toString()
           loginViewModel.autenticar(codigo, senha)
        }
    }

    private fun autenticacaoObserver() {
        loginViewModel.loginViewState.observe(viewLifecycleOwner) {
            val action = LoginFragmentDirections.actionLoginFragmentToMenuFragment()
           findNavController().navigate(action)
        }
    }

    private fun exceptionObserver() {
        loginViewModel.exceptionViewState.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadingObserver() {
        loginViewModel.isLoadingViewState.observe(viewLifecycleOwner) {
            when (it) {
                true -> showProgressBar()
                false -> hideProgressBar()
            }
        }
    }

    private fun showProgressBar() {
        progressDialog?.show()
    }

    private fun hideProgressBar() {
        progressDialog?.dismiss()
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}