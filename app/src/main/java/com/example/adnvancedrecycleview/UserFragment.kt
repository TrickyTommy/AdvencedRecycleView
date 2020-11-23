package com.example.adnvancedrecycleview

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.adnvancedrecycleview.adapter.HomeAdapter
import com.example.adnvancedrecycleview.clients.NetworkProvider
import com.example.adnvancedrecycleview.model.ResponseData
import com.example.adnvancedrecycleview.services.HomeDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //
        val progressBar= activity?.findViewById<ProgressBar>(R.id.pb_home)
        val datasource = NetworkProvider.providesHttpAdapter().create(HomeDataSource::class.java)
        datasource.discoverUser().enqueue(object : Callback<ResponseData> {
            override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
                progressBar?.visibility = View.GONE
                val results = response.body()?.results
                val itemAdapter = activity?.findViewById<RecyclerView>(R.id.rv_home)
                itemAdapter?.addItemDecoration(
                    DividerItemDecoration(context,
                        DividerItemDecoration.VERTICAL)
                )
                itemAdapter?.adapter  = HomeAdapter( result = results ?: emptyList())
            }

            override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                Log.e(HomeActivity::class.java.simpleName, "${t.printStackTrace()}")

            }
        })

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false)


    }



}