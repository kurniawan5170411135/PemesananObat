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
import kotlinx.android.synthetic.main.activity_pesan_obat.*
import org.json.JSONObject

class PesanObat : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesan_obat)

        TampilPesanan()

        san.setOnClickListener() {
            create2()
        }

        val bundle = intent.extras
        val id_pengguna = bundle?.get("id").toString()

        kem.setOnClickListener() {
            intent = Intent(this, menu::class.java)
            intent.putExtra("id", id_pengguna)
            startActivity(intent)
        }

        psnlagi.setOnClickListener() {
            intent = Intent(this, MenuObat::class.java)
            intent.putExtra("id", id_pengguna)
            startActivity(intent)
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        val bundle = intent.extras
        val id_pengguna = bundle?.get("id").toString()
        val a = bundle?.get("id_obat").toString()


        intent = Intent(this, MenuObat::class.java)
        intent.putExtra("id",id_pengguna)
        intent.putExtra("id_obat",a)
        startActivity(intent)
        return true
    }



    private fun TampilPesanan(){
        val loading = ProgressDialog(this)
        loading.setMessage("Memuat data...")
        loading.show()

        val bundle = intent.extras
        val a = bundle?.get("id_obat").toString()

        AndroidNetworking.post(ApiEndPoint.READ4)
            .addBodyParameter("id_obat",a)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {

                    val jsonArray = response?.optJSONArray("result")
                    loading.dismiss()

                    for(i in 0 until jsonArray?.length()!!) {
                        val jsonObject = jsonArray?.optJSONObject(i)
                        val merekk = jsonObject.getString("nama_obat").toString()
                        val kapasitass = jsonObject.getString("harga").toString()
                        val id1 = jsonObject.getString("id_obat").toString()

                        if (jsonArray?.length()-1 == i){
                            loading.dismiss()
                            nobat.text = merekk
                            nharga.text = kapasitass
                            nidobat.text = id1
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

    private fun create2(){
        val loading = ProgressDialog(this)
        loading.setMessage("Menambahkan data...")
        loading.show()
        val bundle = intent.extras
        val id_pengguna = bundle?.get("id").toString()
        val a = bundle?.get("id_obat").toString()

        AndroidNetworking.post(ApiEndPoint.CREATE2)
            .addBodyParameter("id",id_pengguna)
            .addBodyParameter("id_obat",a)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {

                override fun onResponse(response: JSONObject?) {
                    loading.dismiss()
                    Toast.makeText(applicationContext,"terpesan", Toast.LENGTH_SHORT).show()
                }
                override fun onError(anError: ANError?) {
                    loading.dismiss()
                    Log.d("ONERROR",anError?.errorDetail?.toString())
                    Toast.makeText(applicationContext,"Connection Failure", Toast.LENGTH_SHORT).show()
                }
            })
    }
}
