package com.example.remed.view.route

interface DestinasiNavigasi {
    val route: String
    val titleRes: String
}


object DestinasiHome : DestinasiNavigasi {
    override val route = "home"
    override val titleRes = "Sistem Manajemen Buku"
}


object DestinasiEntry : DestinasiNavigasi {
    override val route = "item_entry"
    override val titleRes = "Tambah Buku"
}


object DestinasiDetail : DestinasiNavigasi {
    override val route = "item_details"
    override val titleRes = "Detail Buku"
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}