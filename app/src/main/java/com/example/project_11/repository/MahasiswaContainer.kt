package com.example.project_11.repository

import com.example.pamsql.service.MahasiswaService
import com.example.praktikum12.repository.MahasiswaRepository
import com.example.praktikum12.repository.NetworkMahasiswaRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val mahasiswaRepository: MahasiswaRepository
}

class MahasiswaContainer : AppContainer {
    private val baseUrl = "http://10.2.2.2:8000/umyTI/" // Perbaiki URL Anda
    private val json = Json { ignoreUnknownKeys = true }

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val mahasiswaService: MahasiswaService by lazy {retrofit.create(MahasiswaService::class.java) }
    override val mahasiswaRepository: MahasiswaRepository by lazy {NetworkMahasiswaRepository(mahasiswaService)}

}
