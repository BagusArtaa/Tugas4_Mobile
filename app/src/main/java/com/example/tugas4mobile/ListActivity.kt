package com.example.tugas4mobile

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager // Pindah ke sini
import com.example.tugas4mobile.databinding.ActivityListBinding // Binding untuk layout list
import com.example.tugas4mobile.sqlite.StorageSQLite
class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding // Pastikan nama binding sesuai XML baru
    private lateinit var storage: StorageProdukInterface
    private lateinit var adapter: ProdukAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        storage = StorageSQLite(this)

        // Setup RecyclerView
        binding.rvProduk.layoutManager = LinearLayoutManager(this)
        showProduk()

        binding.btnBack.setOnClickListener {
            finish() // Fungsi ini akan menutup ListActivity dan kembali ke halaman sebelumnya (MainActivity)
        }
        // Tombol Hapus diletakkan di sini agar lebih aman
        binding.btnDeleteAll.setOnClickListener {
            storage.deleteProduk()
            showProduk() // Refresh list setelah hapus
            Toast.makeText(this, "Semua data dihapus", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showProduk() {
        val list = storage.getProduk()
        adapter = ProdukAdapter(list)
        binding.rvProduk.adapter = adapter
    }
}