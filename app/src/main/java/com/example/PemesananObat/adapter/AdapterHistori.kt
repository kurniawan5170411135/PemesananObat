package com.example.PemesananObat.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.PemesananObat.Pembayaran
import com.example.PemesananObat.R

class AdapterHistori (private val context: Pembayaran,
                      private val iddua: ArrayList<String>,
                      private val namaobat: ArrayList<String>,
                      private val hharga: ArrayList<String>,
                      private val ktpq: ArrayList<String>) : ArrayAdapter<String>(context, R.layout.item2, iddua) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.item2, null, true)

        val idnya = rowView.findViewById(R.id.idddd) as TextView
        val obatt = rowView.findViewById(R.id.namaobat11) as TextView
        val hargga = rowView.findViewById(R.id.hargaobat11) as TextView
        val kttp = rowView.findViewById(R.id.kttttttp) as TextView

        idnya.text = iddua[position]
        obatt.text = namaobat[position]
        hargga.text = hharga[position]
        kttp.text = ktpq [position]

        return rowView
    }
}