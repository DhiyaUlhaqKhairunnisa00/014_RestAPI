package com.example.connectapi.ui.home.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.connectapi.model.Kontak
import com.example.connectapi.repository.KontakRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed class KontakUIState{
    data class  Success(val kontak: List<Kontak>) : KontakUIState()
    object Error : KontakUIState()
    object loading : KontakUIState()
}

class HomeViewModel (private val kontakRepository: KontakRepository): ViewModel() {
    var kontakUIState: KontakUIState by mutableStateOf(KontakUIState.loading)
        private set

    init {
        getKontak()
    }

    fun getKontak(){
        viewModelScope.launch {
            kontakUIState = KontakUIState.loading
            kontakUIState = try {
                KontakUIState.Success(kontakRepository.getKontak())
            } catch (e: IOException){
                KontakUIState.Error
            } catch (e: HttpException) {
                KontakUIState.Error
            }
        }
    }
}
