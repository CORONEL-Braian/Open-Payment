package org.techdev.openpayment.installment.data.repository

import org.techdev.openpayment.data.network.APICallManager
import org.techdev.openpayment.data.network.RetrofitService
import org.techdev.openpayment.installment.data.service.InstallmentService
import org.techdev.openpayment.util.RemoteErrorEmitter
import javax.inject.Inject

class InstallmentRemoteRepository @Inject constructor(
    retrofitService: RetrofitService,
    val apiCallManager: APICallManager) {

    private val installmentService = retrofitService.createService(InstallmentService::class.java)

    suspend fun getInstallments(
        remoteErrorEmitter: RemoteErrorEmitter,
        amount: Float,
        paymentMethodId: String,
        issuerId: Int
    ): List<InstallmentsResponse>? =
        apiCallManager.executeSafeApiCall(remoteErrorEmitter) {
            installmentService.getInstallments(
                amount = amount.toString(),
                paymentMethodId = paymentMethodId,
                issuerId = issuerId.toString()
            )
        }

}
