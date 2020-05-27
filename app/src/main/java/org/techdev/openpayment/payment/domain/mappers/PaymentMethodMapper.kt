package org.techdev.openpayment.payment.domain.mappers

import org.techdev.openpayment.payment.data.repository.PaymentMethodResponse
import org.techdev.openpayment.payment.domain.model.PaymentMethod
import org.techdev.openpayment.payment.domain.model.PaymentMethodList

/**
 * Maps the data to the domain model
 */
class PaymentMethodMapper {

    fun convertFromDataModelToDomain(paymentMethodsResponse: List<PaymentMethodResponse>) : PaymentMethodList =
        PaymentMethodList(
            convertPaymentMethodListToDomain(paymentMethodsResponse)
        )

    /**
     * Convert the payment method list from the data to the domain model
     */
    private fun convertPaymentMethodListToDomain(list: List<PaymentMethodResponse>) : List<PaymentMethod> {
        return list.mapIndexed { _, paymentMethodResponse ->
            convertPaymentMethodItemToDomain(paymentMethodResponse)
        }
    }

    private fun convertPaymentMethodItemToDomain(paymentMethodResponse: PaymentMethodResponse) : PaymentMethod {
        return PaymentMethod(
            paymentMethodResponse.id,
            paymentMethodResponse.name,
            paymentMethodResponse.secureThumbnail
        )
    }

}