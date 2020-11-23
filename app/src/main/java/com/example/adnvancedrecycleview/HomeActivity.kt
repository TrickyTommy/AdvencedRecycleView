package com.example.adnvancedrecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import com.example.adnvancedrecycleview.databinding.*

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.adnvancedrecycleview.adapter.HomeAdapter
import com.example.adnvancedrecycleview.clients.NetworkProvider
import com.example.adnvancedrecycleview.model.ResponseData
import com.example.adnvancedrecycleview.services.HomeDataSource
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create
import kotlinx.android.synthetic.main.activity_main.*



class HomeActivity : AppCompatActivity() {

    private val binding by lazy{ActivityHomeBinding.inflate(layoutInflater)}
//    private val adapter by lazy { NetworkProvider(requireContext(), this) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val progressBar= findViewById<ProgressBar>(R.id.pb_home)
        val datasource = NetworkProvider.providesHttpAdapter().create(HomeDataSource::class.java)
        datasource.discoverUser().enqueue(object : Callback<ResponseData>{
            override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
                    progressBar.visibility = View.GONE
                val results = response.body()?.results
                val itemAdapter = findViewById<RecyclerView>(R.id.rv_home)
                itemAdapter.addItemDecoration(DividerItemDecoration(this@HomeActivity,DividerItemDecoration.VERTICAL))
                itemAdapter.adapter  = HomeAdapter( result = results ?: emptyList())
            }

            override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                Log.e(HomeActivity::class.java.simpleName, "${t.printStackTrace()}")

            }
        })
     }
}