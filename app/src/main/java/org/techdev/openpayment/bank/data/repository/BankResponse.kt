package org.techdev.openpayment.bank.data.repository

import com.google.gson.annotations.SerializedName

data class BankResponse(
    val id: String,
    val name: String,
    @SerializedName("secure_thumbnail") val secureThumbnail: String,
    val thumbnail: String
)
