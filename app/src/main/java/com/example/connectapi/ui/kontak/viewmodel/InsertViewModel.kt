package com.example.connectapi.ui.kontak.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.connectapi.model.Kontak
import com.example.connectapi.repository.KontakRepository
import kotlinx.coroutines.launch


class InsertViewModel (private val kontakRepositori: KontakRepository):ViewModel(){
    var insertKontakState by mutableStateOf(InsertUiState())
        private set

    fun updateInsertKontakState(insertUiEvent : InsertUiEvent){
        insertKontakState = InsertUiState(insertUiEvent = insertUiEvent)
    }

    suspend fun insertKontak(){
        viewModelScope.launch {
            try {
                kontakRepositori.insertKontak(insertKontakState.insertUiEvent.toKontak())
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}

data class  InsertUiState(
    val insertUiEvent: InsertUiEvent = InsertUiEvent(),
)

data class InsertUiEvent(
    val id: Int = 0,
    val nama : String = "",
    val email: String = "",
    val nohp: String = ""
)

fun InsertUiEvent.toKontak(): Kontak = Kontak(
    id = id,
    nama = nama,
    email = email,
    telpon = nohp
)

fun Kontak.toUiStateKontak(): InsertUiState = InsertUiState(
    insertUiEvent = toInserUiEvent()
)
fun Kontak.toInserUiEvent(): InsertUiEvent = InsertUiEvent(
    id = id,
    nama = nama,
    email = email,
    nohp = telpon
)


