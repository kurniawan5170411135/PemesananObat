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
import kotlinx.android.synthetic.main.activity_register.*
import org.json.JSONObject


class register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        b_simpan.setOnClickListener {
            create()
            intent = Intent(this, login::class.java)
            startActivity(intent)
        }

        b_kembalib.setOnClickListener{
            intent = Intent(this, login::class.java)
            startActivity(intent)
        }
}


    private fun create(){

        val loading = ProgressDialog(this)
        loading.setMessage("Menambahkan data...")
        loading.show()

        val id = txuser.getText().toString()
        val pass = txpass.getText().toString()

        AndroidNetworking.post(ApiEndPoint.CREATE)
            .addBodyParameter("nama",id)
            .addBodyParameter("pass",pass)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {

                override fun onResponse(response: JSONObject?) {
                    loading.dismiss()
                    Toast.makeText(applicationContext,"terdaftar", Toast.LENGTH_SHORT).show()
                }
                override fun onError(anError: ANError?) {
                    loading.dismiss()
                    Log.d("ONERROR",anError?.errorDetail?.toString())
                    Toast.makeText(applicationContext,"Connection Failure", Toast.LENGTH_SHORT).show()                    }
            })
    }
}

