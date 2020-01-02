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
import kotlinx.android.synthetic.main.activity_akun.*
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject

class Akun : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_akun)

        Daftar()

        updatee.setOnClickListener() {
            update()
        }


        val bundle = intent.extras
        val id_pengguna = bundle?.get("id").toString()

        bttkembali.setOnClickListener() {
            intent = Intent(this, menu::class.java)
            intent.putExtra("id", id_pengguna)
            startActivity(intent)
        }
    }

    private fun Daftar(){

        val loading = ProgressDialog(this)
        loading.setMessage("Memuat data...")
        loading.show()

        val bundle = intent.extras
        val id_pengguna = bundle?.get("id").toString()

        AndroidNetworking.post(ApiEndPoint.READ2)
            .addBodyParameter("id",id_pengguna)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {

                    val jsonArray = response?.optJSONArray("result")
                    loading.dismiss()

                    val jsonObject = jsonArray?.optJSONObject(0)
                    val username = jsonObject?.getString("nama").toString()
                    val password = jsonObject?.getString("pass").toString()
                    val iddee = jsonObject?.getString("id").toString()

                    loading.dismiss()
                    anamma.setText(username)
                    apasss.setText(password)
                    etid.setText(iddee)
                }

                override fun onError(anError: ANError?) {
                    loading.dismiss()
                    Log.d("ONERROR",anError?.errorDetail?.toString())
                    Toast.makeText(applicationContext,"Connection Failure", Toast.LENGTH_SHORT).show()
                }
            })
    }

//************************************************************************************************//

    private fun update(){
    val loading = ProgressDialog(this)
    loading.setMessage("Mengupdate data...")
    loading.show()

    val ktp_r = etid.getText().toString()
    val nama_r = anamma.getText().toString()
    val notelp_r = apasss.getText().toString()

    AndroidNetworking.post(ApiEndPoint.UPDATE1)
        .addBodyParameter("id",ktp_r)
        .addBodyParameter("nama",nama_r)
        .addBodyParameter("pass",notelp_r)
        .setPriority(Priority.MEDIUM)
        .build()
        .getAsJSONObject(object : JSONObjectRequestListener {

            override fun onResponse(response: JSONObject?) {
                loading.dismiss()
                Toast.makeText(applicationContext,"sukses", Toast.LENGTH_SHORT).show()
            }
            override fun onError(anError: ANError?) {
                loading.dismiss()
                Log.d("ONERROR",anError?.errorDetail?.toString())
                Toast.makeText(applicationContext,"Connection Failure", Toast.LENGTH_SHORT).show()
            }
        })
}

//************************************************************************************************//

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        val bundle = intent.extras
        val id_pengguna = bundle?.get("id").toString()

        intent = Intent(this, menu::class.java)
        intent.putExtra("id",id_pengguna)
        startActivity(intent)
        return true
    }
}
