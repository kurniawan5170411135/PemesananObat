package com.example.PemesananObat.adapter

class ApiEndPoint {

    companion object {

        private val SERVER = "http://192.168.43.238/taandroid1/"
        val CREATE  = SERVER + "reegister.php"
        val CREATE2 = SERVER + "createobat.php"
        val READ1   = SERVER + "read.php"
        val READ2   = SERVER + "read2.php"
        val READ3   = SERVER + "readobat.php"
        val READ4   = SERVER + "readpesan.php"
        val READ5   = SERVER + "readhistori.php"
        val UPDATE1   = SERVER + "update.php"
        val READ6   = SERVER + "totharga.php"
    }
}