package com.example.PemesananObat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bayar.*

class bayar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bayar)

            button33.setOnClickListener {
                intent = Intent(this, menu::class.java)
                startActivity(intent)
            }
    }
}
