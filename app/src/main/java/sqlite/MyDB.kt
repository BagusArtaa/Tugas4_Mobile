package com.example.tugas4mobile.sqlite
import android.provider.BaseColumns

object MyDB {

    object TableProduk : BaseColumns {
        const val TABLE_NAME = "produk"
        const val COLUMN_NAMA = "nama_produk"
        const val COLUMN_KOMPOSISI = "komposisi"
    }

    const val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${TableProduk.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "${TableProduk.COLUMN_NAMA} TEXT," +
                "${TableProduk.COLUMN_KOMPOSISI} TEXT)"

    const val SQL_DELETE_ENTRIES =
        "DROP TABLE IF EXISTS ${TableProduk.TABLE_NAME}"
}