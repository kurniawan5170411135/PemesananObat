package com.example.PemesananObat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_account.*

class Account : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        button8.setOnClickListener() {
            intent = Intent(this, menu::class.java)
            startActivity(intent)
        }
        akun.setOnClickListener(){
            intent = Intent (this,account2::class.java)
            startActivity(intent)


    }
}}
