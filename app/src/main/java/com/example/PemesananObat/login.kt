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
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject

class login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        bt_log.setOnClickListener{
            intent = Intent(this, Account::class.java)
            startActivity(intent)
            CekLogin()
        }
    }
//-----------------------------------------------------------------------------------------------
    private fun CekLogin(){
        val loading = ProgressDialog(this)
        loading.setMessage("Memeriksa Data...")
        loading.show()

        val nama = et_user.getText().toString()
        val pass = et_pass.getText().toString()

        AndroidNetworking.post(ApiEndPoint.READ1)
            .addBodyParameter("nama",nama)
            .addBodyParameter("pass",pass)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?){

                    val jsonArray = response?.optJSONArray("result")
                    loading.dismiss()

                    for(i in 0 until jsonArray?.length()!!) {
                        val jsonObject = jsonArray?.optJSONObject(i)
                        val id_pengguna = jsonObject.getString("id").toString()

                        if (jsonArray?.length()-1 == i) {
                            tv_id_ambil.setText(id_pengguna)
                            val id_kir = tv_id_ambil.text
                            intent = Intent(this@login, Account::class.java)
                            intent.putExtra("id", id_kir)
                            startActivity(intent)
                        }
                    }
                    if(tv_id_ambil.getText() == "0"){
                        Toast.makeText(this@login, "gagal", Toast.LENGTH_SHORT).show()
                    }

                }

                override fun onError(anError: ANError?){
                    loading.dismiss()
                    Log.d("ONERROR",anError?.errorDetail?.toString())
                    Toast.makeText(applicationContext,"Connection Failure", Toast.LENGTH_SHORT).show()
                }
            })
    }
    //----------------------------------------------------------------------------------------------
    }



