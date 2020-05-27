package org.techdev.openpayment.payment.data.service

import org.techdev.openpayment.BuildConfig
import org.techdev.openpayment.payment.data.repository.PaymentMethodResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PaymentMethodService {

    @GET("v1/payment_methods")
    suspend fun getPaymentMethods(
        @Query("public_key") appid: String = BuildConfig.PUBLIC_KEY
    ) : List<PaymentMethodResponse>

}