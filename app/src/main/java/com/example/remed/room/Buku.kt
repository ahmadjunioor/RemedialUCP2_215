package com.example.remed.room

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "tblBuku",
    foreignKeys = [ForeignKey(
        entity = Kategori::class,
        parentColumns = ["id"],
        childColumns = ["kategoriId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Buku(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val judul: String,

    val penulis: String,

    val kategoriId: Int,

    val isDeleted: Boolean = false
)