package org.techdev.openpayment.payment.data.repository

import com.google.gson.annotations.SerializedName

data class PaymentMethodResponse(
    val id: String,
    val name: String,
    @SerializedName("payment_type_id") val paymentTypeId: String,
    val status: String,
    @SerializedName("secure_thumbnail") val secureThumbnail: String,
    val thumbnail: String,
    @SerializedName("deferred_capture") val deferredCapture: String,
    val settings: List<Setting>,
    @SerializedName("min_allowed_amount") val minAllowedAmount: Int,
    @SerializedName("max_allowed_amount") val maxAllowedAmount: Int,
    @SerializedName("accreditation_time") val accreditationTime: Int
)

data class Setting(
    @SerializedName("card_number") val cardNumber: CardNumber,
    val bin: Bin,
    @SerializedName("security_code") val securityCode: SecurityCode
)

data class CardNumber(
    val validation: String,
    val lenght: Int
)

data class Bin(
    val pattern: String,
    @SerializedName("installments_pattern") val installmentsPattern: String,
    @SerializedName("exclusion_pattern") val exclusionPattern: String
)

data class SecurityCode(
    val length: Int,
    @SerializedName("card_location") val cardLocation: String,
    val mode: String
)