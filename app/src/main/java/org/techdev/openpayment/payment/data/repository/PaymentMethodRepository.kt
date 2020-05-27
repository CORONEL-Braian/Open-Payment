package org.techdev.openpayment.payment.data.repository

import org.techdev.openpayment.payment.domain.model.PaymentMethodList
import org.techdev.openpayment.util.RemoteErrorEmitter

interface PaymentMethodRepository {

    suspend fun getPaymentMethods(remoteErrorEmitter: RemoteErrorEmitter)
            : PaymentMethodList?

    interface RemoteRepository {
        suspend fun getPaymentMethods(remoteErrorEmitter: RemoteErrorEmitter)
                : List<PaymentMethodResponse>?
    }

}