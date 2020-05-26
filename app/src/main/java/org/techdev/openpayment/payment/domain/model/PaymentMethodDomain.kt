package org.techdev.openpayment.payment.domain.model


data class PaymentMethodList(
    val id: String,
    val name: String,
    val secureThumbnail: String
)