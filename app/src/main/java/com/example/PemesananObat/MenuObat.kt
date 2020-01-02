package com.example.PemesananObat

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.example.PemesananObat.adapter.ApiEndPoint
import com.example.PemesananObat.adapter.AdapterObat
import kotlinx.android.synthetic.main.activity_menu_obat.*
import org.json.JSONObject

class MenuObat : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_obat)
        cariobat()
    }

    override fun onResume(){
        super.onResume()
        tampilobat()
    }


    private fun cariobat(){
        lpesanobat1.setOnItemClickListener{ adapterView, view, position, idobat->

            val idnya = adapterView.getItemAtPosition(position)
            val a = idnya.toString()
            val bundle = intent.extras
            val id_penumpang = bundle?.get("id").toString()

            intent = Intent(this, PesanObat::class.java)
            intent.putExtra("id_obat",a)
            intent.putExtra("id",id_penumpang)
            startActivity(intent)
        }
    }


    private fun tampilobat(){
        val loading = ProgressDialog(this)
        loading.setMessage("Memuat data...")
        loading.show()

        AndroidNetworking.post(ApiEndPoint.READ3)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {

                    val jsonArray = response?.optJSONArray("result")
                    loading.dismiss()

                    val list_a = arrayListOf<String>()
                    val list_b = arrayListOf<String>()
                    val list_c = arrayListOf<String>()

                    for(i in 0 until jsonArray?.length()!!) {
                        val jsonObject = jsonArray?.optJSONObject(i)
                        list_a.add((jsonObject.getString("nama_obat")).toString())
                        list_b.add((jsonObject.getString("harga")).toString())
                        list_c.add((jsonObject.getString("id_obat")).toString())

                        if (jsonArray?.length()-1 == i) {
                            loading.dismiss()
                            val adapter = AdapterObat(this@MenuObat, list_c, list_a, list_b)
                            lpesanobat1.adapter = adapter
                        }
                    }
                }

                override fun onError(anError: ANError?) {
                    loading.dismiss()
                    Log.d("ONERROR",anError?.errorDetail?.toString())
                    Toast.makeText(applicationContext,"Connection Failure", Toast.LENGTH_SHORT).show()
                }

            })
    }
}
