package org.techdev.openpayment.installment.data.repository

import com.google.gson.annotations.SerializedName

data class InstallmentsResponse(
    @SerializedName("payment_method_id") val paymentMethodId: String,
    @SerializedName("payment_type_id") val paymentTypeId: String,
    val issuer: Issuer,
    @SerializedName("payer_costs") val payerCosts: List<PayerCost>
)

data class Issuer(
    val id: String,
    val name: String,
    @SerializedName("secure_thumbnail") val secureThumbnail: String,
    val thumbnail: String
)

data class PayerCost(
    val installments: String,
    @SerializedName("installment_rate") val installmentRate: Double,
    val labels: List<String>,
    @SerializedName("installment_rate_collector") val installmentRateCollector: List<String>,
    @SerializedName("recommended_message") val recommendedMessage: String,
    @SerializedName("installment_amount") val installmentAmount: String,
    @SerializedName("total_amount") val totalAmount: String,
    @SerializedName("payment_method_option_id") val paymentMethodOptionId: String
)