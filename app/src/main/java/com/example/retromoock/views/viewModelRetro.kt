package com.example.retromoock.views

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.retromoock.views.network.ClientRetro
import com.example.retromoock.views.network.ResponsesFrasi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class viewModelRetro(application: Application) : AndroidViewModel(application) {

    var lista = MutableLiveData<List<ResponsesFrasi>>()

    init {
        getFrasi(application)

    }

    private fun getFrasi(ctx:Context) {

        ClientRetro.instance?.createService()?.getFrasi()
            ?.enqueue(object : Callback<List<ResponsesFrasi>> {
                override fun onResponse(
                    call: Call<List<ResponsesFrasi>>,
                    response: Response<List<ResponsesFrasi>>
                ) {

                    lista.value = response.body()

                }

                override fun onFailure(call: Call<List<ResponsesFrasi>>, t: Throwable) {
                    Toast.makeText(ctx, t.stackTrace.toString(), Toast.LENGTH_SHORT).show()
                }

            })

    }


}

