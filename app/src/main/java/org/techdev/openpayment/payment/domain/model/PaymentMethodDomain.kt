package org.techdev.openpayment.payment.domain.model


data class PaymentMethodList(
    val paymentMethods: List<PaymentMethod>
)

data class PaymentMethod(
    val id: String,
    val name: String,
    val secureThumbnail: String
)