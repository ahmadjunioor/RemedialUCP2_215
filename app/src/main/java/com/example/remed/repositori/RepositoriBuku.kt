package com.example.remed.repositori

import com.example.remed.room.Buku
import com.example.remed.room.FisikBuku
import com.example.remed.room.Kategori
import com.example.remed.room.LibraryDao
import kotlinx.coroutines.flow.Flow

interface RepositoriBuku {
    fun getAllKategori(): Flow<List<Kategori>>
    fun getAllBuku(): Flow<List<Buku>>
    fun getBukuByKategori(kategoriId: Int): Flow<List<Buku>>

    suspend fun insertKategori(kategori: Kategori)
    suspend fun insertBuku(buku: Buku)
    suspend fun insertFisikBuku(fisikBuku: FisikBuku)

    suspend fun updateKategori(kategori: Kategori)
    suspend fun updateBuku(buku: Buku)

    suspend fun deleteKategori(id: Int)
    suspend fun deleteBuku(id: Int)
    suspend fun deleteFisikBuku(idFisik: String)

    suspend fun cekBukuDipinjam(kategoriId: Int): Int
}

class OfflineRepositoribuku(
    private val libraryDao: LibraryDao
) : RepositoriBuku {

    override fun getAllKategori(): Flow<List<Kategori>> = libraryDao.getAllKategori()
    override fun getAllBuku(): Flow<List<Buku>> = libraryDao.getAllBuku()

    override fun getBukuByKategori(kategoriId: Int): Flow<List<Buku>> =
        libraryDao.getBukuByKategori(kategoriId)

    override suspend fun insertKategori(kategori: Kategori) = libraryDao.insertKategori(kategori)
    override suspend fun insertBuku(buku: Buku) = libraryDao.insertBuku(buku)
    override suspend fun insertFisikBuku(fisikBuku: FisikBuku) = libraryDao.insertFisikBuku(fisikBuku)

    override suspend fun updateKategori(kategori: Kategori) = libraryDao.updateKategori(kategori)
    override suspend fun updateBuku(buku: Buku) = libraryDao.updateBuku(buku)

    override suspend fun deleteKategori(id: Int) = libraryDao.deleteKategori(id)
    override suspend fun deleteBuku(id: Int) = libraryDao.deleteBuku(id)
    override suspend fun deleteFisikBuku(idFisik: String) = libraryDao.deleteFisikBuku(idFisik)

    override suspend fun cekBukuDipinjam(kategoriId: Int): Int =
        libraryDao.countBukuDipinjamDiKategori(kategoriId)
}