package com.example.project_11

import android.app.Application
import com.example.project_11.repository.AppContainer
import com.example.project_11.repository.MahasiswaContainer

class MahasiswaApp : Application() {
    lateinit var  container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = MahasiswaContainer()
    }
}