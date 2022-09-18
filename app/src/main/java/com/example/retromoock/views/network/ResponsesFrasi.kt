package com.example.retromoock.views.network

import com.google.gson.annotations.SerializedName

data class ResponsesFrasi(
    @SerializedName("autore") val autore: String,
    @SerializedName("frase") val frasi: String,
    @SerializedName("img") val img: String?=null,
    @SerializedName("des") val des: String,
    @SerializedName("difficolta") val difficolta: String,
    @SerializedName("im_url") val im_url: String,
    @SerializedName("ingredienti") val ingredienti: String?=null,
    @SerializedName("tempo") val tempo: String,
    @SerializedName("titolo_ricetta") val titolo_ricetta: String,
    @SerializedName("procedimento") val procedimento: String


)




