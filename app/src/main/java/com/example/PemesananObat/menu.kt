package com.example.PemesananObat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.PemesananObat.adapter.adapter
import com.example.PemesananObat.adapter.model
import com.example.PemesananObat.menuobat.*
import kotlinx.android.synthetic.main.activity_menu.*

class menu : AppCompatActivity() {
    lateinit var listView : ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        button18.setOnClickListener {
            intent = Intent(this, Account::class.java)
            startActivity(intent)
        }
        button19.setOnClickListener {
            intent = Intent(this, bayar::class.java)
            startActivity(intent)
        }
        listView = findViewById(R.id.listView)
        var list = mutableListOf<model>()

        list.add(model("OBAT DEMAM",   " ",   R.drawable.od  ))
        list.add(model("OBAT PILEK",   " ",   R.drawable.oplk  ))
        list.add(model("OBAT BATUK",   " ",   R.drawable.ob  ))
        list.add(model("SUPLEMEN",   " ",   R.drawable.sup  ))
        list.add(model("OBAT LUAR",   " ",   R.drawable.ol  ))

        listView.adapter = adapter(this,R.layout.item,list)

        listView.setOnItemClickListener { parent, view, position, id ->

            if (position == 0) {
                intent = Intent(this, odemam::class.java)
                startActivity(intent)
            }
            if (position == 1) {
                intent = Intent(this, opilek::class.java)
                startActivity(intent)
            }
            if (position == 2) {
                intent = Intent(this, obatuk::class.java)
                startActivity(intent)
            }
            if (position == 3) {
                intent = Intent(this, suplemen::class.java)
                startActivity(intent)
            }
            if (position == 4) {
                intent = Intent(this, oluar::class.java)
                startActivity(intent)
            }
        }
    }
}
