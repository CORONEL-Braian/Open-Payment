package org.techdev.openpayment.bank.data.service

import org.techdev.openpayment.BuildConfig
import org.techdev.openpayment.bank.data.repository.BankResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BankService {

    @GET("v1/payment_methods/card_issuers")
    suspend fun getBanks(
        @Query("public_key") appid: String = BuildConfig.PUBLIC_KEY,
        @Query("payment_method_id") paymentMethodId: String
    ) : List<BankResponse>

}