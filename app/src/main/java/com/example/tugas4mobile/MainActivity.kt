package com.example.tugas4mobile

import android.content.Intent // Tambahan baru untuk pindah halaman
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tugas4mobile.databinding.ActivityMainBinding
import com.example.tugas4mobile.sqlite.StorageSQLite

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var storage: StorageProdukInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        storage = StorageSQLite(this)

        // Tombol simpan tetap di sini
        binding.btnSave.setOnClickListener {
            val nama = binding.etNamaProduk.text.toString()
            val komposisi = binding.etKomposisi.text.toString()
            val produk = Produk(nama, komposisi)

            if (produk.isAvailable()) {
                storage.saveProduk(produk)
                binding.etNamaProduk.text.clear()
                binding.etKomposisi.text.clear()
                Toast.makeText(this, "Data Tersimpan!", Toast.LENGTH_SHORT).show()
            }
        }

        // TOMBOL BARU: Lihat Produk
        binding.btnLihatProduk.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
    }
}