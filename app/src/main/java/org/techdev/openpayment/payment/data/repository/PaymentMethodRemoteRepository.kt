package org.techdev.openpayment.payment.data.repository

import org.techdev.openpayment.data.network.APICallManager
import org.techdev.openpayment.data.network.RetrofitService
import org.techdev.openpayment.payment.data.service.PaymentMethodService
import org.techdev.openpayment.util.RemoteErrorEmitter
import javax.inject.Inject

class PaymentMethodRemoteRepository @Inject constructor(
    retrofitService: RetrofitService,
    private val apiCallManager: APICallManager
) : PaymentMethodRepository.RemoteRepository {

    private val paymentMethodService = retrofitService.createService(PaymentMethodService::class.java)

    override suspend fun getPaymentMethods(remoteErrorEmitter: RemoteErrorEmitter): List<PaymentMethodResponse>? =
        apiCallManager.executeSafeApiCall(remoteErrorEmitter) {
            paymentMethodService.getPaymentMethods()
        }

}