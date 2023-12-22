package com.example.connectapi.repository

import com.example.connectapi.model.Kontak
import com.example.connectapi.service_api.KontakService

interface KontakRepository {
    /** Fetches list of Kontak from kontakApi */
    suspend fun getKontak(): List<Kontak>
}

class NetworkKontakRepository(
    private val kontakApiService: KontakService
) : KontakRepository {
    /** Fetches list of Kontak from kontakApi */
    override suspend fun getKontak(): List<Kontak> = kontakApiService.getKontak()
}