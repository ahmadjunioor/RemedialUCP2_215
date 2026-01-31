package com.example.remed.room

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "tblFisikBuku")
data class FisikBuku(
    @PrimaryKey
    val idFisik: String,

    val bukuId: Int,

    val status: String,

    val kondisi: String,

    val isDeleted: Boolean = false
)