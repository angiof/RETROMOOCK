package com.example.retromoock.views.network

import com.google.gson.annotations.SerializedName

data class ResponsesFrasi(@SerializedName("autore") val autore: String,@SerializedName("frase") val frasi: String)