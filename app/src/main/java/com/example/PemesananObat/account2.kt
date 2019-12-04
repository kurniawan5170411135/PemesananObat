package com.example.PemesananObat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_account2.*

class account2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account2)

        button11.setOnClickListener {
            intent = Intent(this, Account::class.java)
            startActivity(intent)
    }
//    private fun TampilPenumpang(){
//
//        val loading = ProgressDialog(this)
//        loading.setMessage("Memuat data...")
//        loading.show()
//
//        val bundle = intent.extras
//        val id_pelanggan = bundle?.get("id_pelanggan").toString()
//
//        AndroidNetworking.post(ApiEndPoint.READ2)
//            .addBodyParameter("id_pelanggan",id_pelanggan)
//            .setPriority(Priority.MEDIUM)
//            .build()
//            .getAsJSONObject(object : JSONObjectRequestListener {
//                override fun onResponse(response: JSONObject?) {
//
//                    val jsonArray = response?.optJSONArray("result")
//                    loading.dismiss()
//
//                    val jsonObject = jsonArray?.optJSONObject(0)
//                    val namaa = jsonObject?.getString("nama").toString()
//
//
//                    loading.dismiss()
//                    nama1.setText(namaa)
//
//                }
//
//                override fun onError(anError: ANError?) {
//                    loading.dismiss()
//                    Log.d("ONERROR",anError?.errorDetail?.toString())
//                    Toast.makeText(applicationContext,"Connection Failure", Toast.LENGTH_SHORT).show()
//                }
//            })
//    }
}}
