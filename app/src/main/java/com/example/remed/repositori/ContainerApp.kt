package com.example.remed.repositori

import android.content.Context
import com.example.remed.room.LibraryDatabase

interface AppContainer {
    val repositoriBuku: RepositoriBuku
}

class DefaultAppContainer(context: Context) : AppContainer {
    private val database = LibraryDatabase.getDatabase(context)

    override val repositoriBuku: RepositoriBuku by lazy {
        OfflineRepositoriBuku(libraryDao = database.libraryDao())
    }
}


lateinit var Container: AppContainer