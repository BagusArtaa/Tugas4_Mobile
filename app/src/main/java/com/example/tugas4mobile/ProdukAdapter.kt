package com.example.tugas4mobile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProdukAdapter(private val listProduk: List<Produk>) :
    RecyclerView.Adapter<ProdukAdapter.ProdukViewHolder>() {

    class ProdukViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNama: TextView = itemView.findViewById(R.id.tvNamaProduk)
        val tvKomposisi: TextView = itemView.findViewById(R.id.tvKomposisi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdukViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_produk, parent, false)
        return ProdukViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProdukViewHolder, position: Int) {
        val produk = listProduk[position]
        holder.tvNama.text = produk.namaProduk
        holder.tvKomposisi.text = produk.komposisi
    }

    override fun getItemCount(): Int {
        return listProduk.size
    }
}