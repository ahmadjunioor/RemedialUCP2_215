package com.example.remed.viewmodel.provider

import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.remed.repositori.Container
import com.example.remed.viewmodel.HomeViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {

        initializer {
            HomeViewModel(
                repositoriBuku = Container.repositoriBuku
            )
        }
    }
}