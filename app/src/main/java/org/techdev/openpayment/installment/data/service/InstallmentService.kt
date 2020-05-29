package org.techdev.openpayment.installment.data.service

import org.techdev.openpayment.BuildConfig
import org.techdev.openpayment.installment.data.repository.InstallmentsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface InstallmentService {

    @GET("v1/payment_methods/card_issuers")
    suspend fun getInstallments(
        @Query("public_key") appid: String = BuildConfig.PUBLIC_KEY,
        @Query("payment_method_id") paymentMethodId: String
    ) : InstallmentsResponse

}