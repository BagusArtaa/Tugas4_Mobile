package com.example.tugas4mobile.sqlite

import android.content.ContentValues
import android.content.Context
import com.example.tugas4mobile.Produk
import com.example.tugas4mobile.StorageProdukInterface
import com.example.tugas4mobile.sqlite.DatabaseHelper
import com.example.tugas4mobile.sqlite.MyDB

class StorageSQLite(context: Context) : StorageProdukInterface {

    private val dbHelper = DatabaseHelper(context)

    override fun saveProduk(produk: Produk) {
        val db = dbHelper.writableDatabase

        val values = ContentValues().apply {
            put(MyDB.TableProduk.COLUMN_NAMA, produk.namaProduk)
            put(MyDB.TableProduk.COLUMN_KOMPOSISI, produk.komposisi)
        }

        db.insert(MyDB.TableProduk.TABLE_NAME, null, values)
    }

    override fun getProduk(): List<Produk> {
        val db = dbHelper.readableDatabase
        val list = mutableListOf<Produk>()

        val projection = arrayOf(
            MyDB.TableProduk.COLUMN_NAMA,
            MyDB.TableProduk.COLUMN_KOMPOSISI
        )

        val cursor = db.query(
            MyDB.TableProduk.TABLE_NAME,
            projection,
            null,
            null,
            null,
            null,
            null
        )

        with(cursor) {
            while (moveToNext()) {
                val nama = getString(getColumnIndexOrThrow(MyDB.TableProduk.COLUMN_NAMA))
                val komposisi = getString(getColumnIndexOrThrow(MyDB.TableProduk.COLUMN_KOMPOSISI))

                list.add(Produk(nama, komposisi))
            }
        }

        cursor.close()
        return list
    }

    override fun deleteProduk() {
        val db = dbHelper.writableDatabase
        db.delete(MyDB.TableProduk.TABLE_NAME, null, null)
    }
}