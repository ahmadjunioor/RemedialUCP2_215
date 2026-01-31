package com.example.remed.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface LibraryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertKategori(kategori: Kategori)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBuku(buku: Buku)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFisikBuku(fisikBuku: FisikBuku)
    @Update
    suspend fun updateKategori(kategori: Kategori)

    @Update
    suspend fun updateBuku(buku: Buku)

    @Update
    suspend fun updateFisikBuku(fisikBuku: FisikBuku)


    @Query("UPDATE tblKategori SET isDeleted = 1 WHERE id = :id")
    suspend fun deleteKategori(id: Int)

    @Query("UPDATE tblBuku SET isDeleted = 1 WHERE id = :id")
    suspend fun deleteBuku(id: Int)

    @Query("UPDATE tblFisikBuku SET isDeleted = 1 WHERE idFisik = :idFisik")
    suspend fun deleteFisikBuku(idFisik: String)

    @Query("SELECT * FROM tblKategori WHERE isDeleted = 0 ORDER BY nama ASC")
    fun getAllKategori(): Flow<List<Kategori>>

    @Query("SELECT * FROM tblBuku WHERE isDeleted = 0 ORDER BY judul ASC")
    fun getAllBuku(): Flow<List<Buku>>

    @Query("SELECT * FROM tblBuku WHERE kategoriId = :kategoriId AND isDeleted = 0")
    fun getBukuByKategori(kategoriId: Int): Flow<List<Buku>>

    @Query("""
        SELECT COUNT(*) FROM tblFisikBuku f 
        INNER JOIN tblBuku b ON f.bukuId = b.id 
        WHERE b.kategoriId = :kategoriId 
        AND f.status = 'Dipinjam' 
        AND f.isDeleted = 0
    """)
    suspend fun countBukuDipinjamDiKategori(kategoriId: Int): Int
}