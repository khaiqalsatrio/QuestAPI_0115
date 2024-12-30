package com.example.project_11.ui.viewModel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.project_11.MahasiswaApplications

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer { HomeViewModel(aplikasiMahasiswa().container.mahasiswaRepository)}
        initializer { insertViewModel(aplikasiMahasiswa().container.mahasiswaRepository)}
        initializer { DetailViewModel(aplikasiMahasiswa().container.mahasiswaRepository)}
        initializer { UpdateViewModel(aplikasiMahasiswa().container.mahasiswaRepository)}
    }

    fun CreationExtras.aplikasiMahasiswa():MahasiswaApplications =
        (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApplications)

}