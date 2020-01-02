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
import com.example.PemesananObat.adapter.AdapterHistori
import com.example.PemesananObat.adapter.ApiEndPoint
import kotlinx.android.synthetic.main.activity_pembayaran.*
import org.json.JSONObject

class Pembayaran : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pembayaran)

        Tampilhistori()

        val bundle = intent.extras
        val id_pengguna = bundle?.get("id").toString()

            aakembalii.setOnClickListener() {
                intent = Intent(this, menu::class.java)
                intent.putExtra("id", id_pengguna)
                startActivity(intent)
            }
    }

    override fun onResume() {
        super.onResume()
        harga()
    }

    private fun Tampilhistori(){
        val loading = ProgressDialog(this)
        loading.setMessage("Memuat data...")
        loading.show()

        val bundle = intent.extras
        val id_pengguna = bundle?.get("id").toString()

        AndroidNetworking.post(ApiEndPoint.READ5)
            .addBodyParameter("id",id_pengguna)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {

                    val jsonArray = response?.optJSONArray("result")
                    loading.dismiss()

                    val list_a = arrayListOf<String>()
                    val list_b = arrayListOf<String>()
                    val list_c = arrayListOf<String>()
                    val list_d = arrayListOf<String>()

                    for(i in 0 until jsonArray?.length()!!) {
                        val jsonObject = jsonArray?.optJSONObject(i)
                        list_a.add((jsonObject.getString("kd_bayar")).toString())
                        list_b.add((jsonObject.getString("nama_obat")).toString())
                        list_c.add((jsonObject.getString("harga")).toString())
                        list_d.add((jsonObject.getString("id")).toString())

                        if (jsonArray?.length()-1 == i) {
                            loading.dismiss()
                            val adapter = AdapterHistori(this@Pembayaran, list_a, list_b, list_c, list_d)
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

    private fun harga(){

        val loading = ProgressDialog(this)
        loading.setMessage("Memuat data...")
        loading.show()

        val bundle = intent.extras
        val id_pengguna = bundle?.get("id").toString()

        AndroidNetworking.post(ApiEndPoint.READ6)
            .addBodyParameter("id",id_pengguna)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {

                    val jsonArray = response?.optJSONArray("result")
                    loading.dismiss()

                    val jsonObject = jsonArray?.optJSONObject(0)
                    val harr = jsonObject?.getString("totalhar").toString()
                    val idew = jsonObject?.getString("id").toString()

                    loading.dismiss()
                    tothar.setText(harr)
                    idhar.setText(idew)
                }

                override fun onError(anError: ANError?) {
                    loading.dismiss()
                    Log.d("ONERROR",anError?.errorDetail?.toString())
                    Toast.makeText(applicationContext,"Connection Failure", Toast.LENGTH_SHORT).show()
                }
            })
    }
}

