package com.example.PemesananObat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*

class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val bundle = intent.extras
        val id_pengguna = bundle?.get("id").toString()

        button3.setOnClickListener {
            intent = Intent(this, Akun::class.java)
            intent.putExtra("id",id_pengguna)
            startActivity(intent)
        }
        button.setOnClickListener {
            intent = Intent(this, MenuObat::class.java)
            intent.putExtra("id",id_pengguna)
            startActivity(intent)}

        button2.setOnClickListener {
            intent = Intent(this, Pembayaran::class.java)
            intent.putExtra("id",id_pengguna)
            startActivity(intent)}

    }
}
