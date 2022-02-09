package com.example.comum.presentation.ui


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comum.domain.model.LoginModel
import com.example.comum.domain.useCase.LogarUseCase
import com.example.comum.domain.useCase.LogarUseCaseImpl.Params as LogarParams
import com.example.comum.presentation.utilidade.SingleLiveEvent
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class LoginViewModel(private val logarUseCase: LogarUseCase) : ViewModel() {

     private val _loginViewState = SingleLiveEvent<LoginModel>()
     val loginViewState: LiveData<LoginModel> = _loginViewState

     private val _isLoading = SingleLiveEvent<Boolean>()
     val isLoadingViewState: LiveData<Boolean> = _isLoading

     private val _exception = SingleLiveEvent<Throwable>()
     val exceptionViewState: LiveData<Throwable> = _exception

     private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
          exibirLoading()
          _exception.postValue(throwable)
     }

     fun autenticar(codigo: String, senha: String)  {
          try {
               viewModelScope.launch(exceptionHandler) {
                    exibirLoading(true)
                    _loginViewState.value = withContext(Dispatchers.Main) {
                         logarUseCase.logar(
                              LogarParams(codigo, senha)
                         )
                    }!!
                    exibirLoading()
               }
          } catch (ex: Exception){
             Log.d("login", "error :: ${ex.message}")
          }
     }

     fun exibirLoading(exibir: Boolean = false){
          _isLoading.value = exibir
     }
}