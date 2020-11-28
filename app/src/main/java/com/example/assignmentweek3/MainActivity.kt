package com.example.assignmentweek3

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.assignmentweek3.adapter.BeritaAdapter
import com.example.assignmentweek3.model.Berita
import com.example.assignmentweek3.model.ResponseServer
import com.example.assignmentweek3.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (isConnect()) {
        ConfigNetwork.getRetrofit().getDataBerita().enqueue(object:Callback<ResponseServer> {
            override fun onFailure(call: Call<ResponseServer>, t: Throwable) {

                progress.visibility = View.GONE
                Log.d("error server", t.message)
            }

            override fun onResponse(
                call: Call<ResponseServer>,
                response: Response<ResponseServer>
            ) {
                Log.d("response server", response.message())
                if (response.isSuccessful) {
                    progress.visibility = View.GONE

                    val status = response.body()?.status
                    if (status == "ok") {
                        val article = response.body()?.articles

                        showData(article)
                    }
                }
            }

        })
        }else {
            progress.visibility = View.GONE
            Toast.makeText(this,"Device is not connected", Toast.LENGTH_SHORT).show()


        }
    }
    fun isConnect() : Boolean{
        val connect : ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return connect.activeNetworkInfo != null && connect.activeNetworkInfo.isConnected

    }

    private fun showData(article : ArrayList<Berita>?){

        listBerita.adapter= BeritaAdapter(article)
    }
}
