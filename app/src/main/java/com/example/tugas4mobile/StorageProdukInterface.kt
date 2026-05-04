package com.example.tugas4mobile

interface StorageProdukInterface {

    fun saveProduk(produk: Produk)

    fun getProduk(): List<Produk>

    fun deleteProduk()
}