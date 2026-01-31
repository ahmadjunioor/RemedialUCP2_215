package com.example.remed.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblKategori")
data class Kategori(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val nama: String,

    val deskripsi: String,

    val parentId: Int? = null,

    val isDeleted: Boolean = false
)