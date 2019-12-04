package com.example.PemesananObat.adapter

class ApiEndPoint {

    companion object {

        private val SERVER = "http://192.168.43.238/taandroid1/"
        val CREATE  = SERVER + "reegister.php"
        val READ1   = SERVER + "read.php"
        val READ2   = SERVER + "read2.php"
    }
}