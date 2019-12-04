package com.example.PemesananObat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        b_login.setOnClickListener(){
            intent = Intent (this,login::class.java)
            startActivity(intent)
        }
        b_daftar.setOnClickListener(){
            intent = Intent (this,register::class.java)
            startActivity(intent)
        }
    }

}
