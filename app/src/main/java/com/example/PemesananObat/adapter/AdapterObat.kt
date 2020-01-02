package com.example.PemesananObat.adapter


import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.PemesananObat.MenuObat
import com.example.PemesananObat.R

class AdapterObat (private val context: MenuObat,
                   private val idobat: ArrayList<String>,
                   private val namaobat: ArrayList<String>,
                   private val hharga: ArrayList<String>) : ArrayAdapter<String>(context, R.layout.item, idobat){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.item, null, true)

        val idnya = rowView.findViewById(R.id.txt_id) as TextView
        val obatt = rowView.findViewById(R.id.txt_obat) as TextView
        val hargga = rowView.findViewById(R.id.txt_harga) as TextView

        idnya.text = idobat[position]
        obatt.text = namaobat[position]
        hargga.text = hharga[position]

        return rowView
    }
}