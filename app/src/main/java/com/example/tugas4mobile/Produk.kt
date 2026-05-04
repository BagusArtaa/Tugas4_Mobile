package com.example.tugas4mobile

data class Produk(
    var namaProduk: String = "",
    var komposisi: String = ""
) {

    fun isAvailable(): Boolean {
        return namaProduk.isNotEmpty()
    }
}