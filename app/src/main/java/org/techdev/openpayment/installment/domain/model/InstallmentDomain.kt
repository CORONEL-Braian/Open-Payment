package org.techdev.openpayment.installment.domain.model

data class Installment(
    val paymentMethodId: String,
    val paymentTypeId: String,
    val issuer: Issuer,
    val payerCosts: List<PayerCost>
)

data class Issuer(
    val id: String,
    val name: String,
    val secureThumbnail: String
)

data class PayerCost(
    val installments: String,
    val labels: List<String>,
    val installmentRateCollector: List<String>,
    val recommendedMessage: String,
    val installmentAmount: String,
    val totalAmount: String
)