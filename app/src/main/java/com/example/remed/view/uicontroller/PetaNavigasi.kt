package com.example.remed.view.uicontroller // Sesuaikan package

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.remed.view.route.DestinasiHome
import com.example.remed.view.route.DestinasiEntry

@Composable
fun PetaNavigasi(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {
        // --- RUTE HALAMAN HOME ---
        composable(route = DestinasiHome.route) {
            HalamanHome(
                navigateToItemEntry = {
                    // Perintah untuk pindah ke halaman Entry
                    navController.navigate(DestinasiEntry.route)
                }
            )
        }

        // --- RUTE HALAMAN ENTRY (TAMBAH DATA) ---
        composable(route = DestinasiEntry.route) {
            // Nanti kita isi ini dengan HalamanEntry() saat sudah dibuat.
            // Untuk sementara biarkan kosong atau Text("Halaman Entry") agar tidak error
        }
    }
}