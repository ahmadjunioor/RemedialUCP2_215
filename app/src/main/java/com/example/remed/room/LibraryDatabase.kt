package com.example.remed.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Kategori::class, Buku::class, FisikBuku::class], version = 1, exportSchema = false)
abstract class LibraryDatabase : RoomDatabase(){

    abstract fun libraryDao(): LibraryDao

    companion object{
        @Volatile
        private var instance: LibraryDatabase? = null

        fun getDatabase(context: Context): LibraryDatabase {
            return(instance?: synchronized(lock = this){
                Room.databaseBuilder(
                    context,
                    LibraryDatabase::class.java,
                    "library_database")
                    .build().also { instance = it }
            })
        }
    }
}