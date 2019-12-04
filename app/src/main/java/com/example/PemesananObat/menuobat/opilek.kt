package com.example.PemesananObat.menuobat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.PemesananObat.R
import com.example.PemesananObat.menu
import kotlinx.android.synthetic.main.activity_opilek.*

class opilek : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opilek)
        kembaliplk.setOnClickListener(){
            intent = Intent (this, menu::class.java)
            startActivity(intent)
        }
    }
}
