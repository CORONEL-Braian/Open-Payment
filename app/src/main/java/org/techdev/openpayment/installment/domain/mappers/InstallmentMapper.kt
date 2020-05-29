package org.techdev.openpayment.installment.domain.mappers

import org.techdev.openpayment.installment.data.repository.InstallmentsResponse
import org.techdev.openpayment.installment.domain.model.Installment
import org.techdev.openpayment.installment.domain.model.Issuer
import org.techdev.openpayment.installment.domain.model.PayerCost
import org.techdev.openpayment.installment.data.repository.PayerCost as DataPayerCost

/**
 * Maps the data to the domain model
 */
class InstallmentMapper {

    fun convertFromDataModelToDomain(listInstallmentsResponse: List<InstallmentsResponse>) : Installment =
        convertInstallmentItemToDomain(listInstallmentsResponse[0])

    /**
     * Convert the installment from the data to the domain model
     */
    private fun convertInstallmentItemToDomain(installmentResponse: InstallmentsResponse) : Installment {
        return Installment(
            installmentResponse.paymentMethodId,
            installmentResponse.paymentTypeId,
            Issuer(
                installmentResponse.issuer.id,
                installmentResponse.issuer.name,
                installmentResponse.issuer.secureThumbnail
            ),
            convertPayerCostListToDomain(installmentResponse.payerCosts)
        )
    }

    private fun convertPayerCostListToDomain(list: List<DataPayerCost>) : List<PayerCost> {
        return list.mapIndexed { _, payerCost ->
            convertPayerCostItemToDomain(payerCost)
        }
    }

    private fun convertPayerCostItemToDomain(item: DataPayerCost) =
        PayerCost(
            item.installments,
            item.labels,
            item.installmentRateCollector,
            item.recommendedMessage,
            item.installmentAmount,
            item.totalAmount
        )

}