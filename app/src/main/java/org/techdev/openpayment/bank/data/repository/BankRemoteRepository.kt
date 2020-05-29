package org.techdev.openpayment.bank.data.repository

import org.techdev.openpayment.data.network.APICallManager
import org.techdev.openpayment.data.network.RetrofitService
import org.techdev.openpayment.bank.data.service.BankService
import org.techdev.openpayment.util.RemoteErrorEmitter
import javax.inject.Inject

class BankRemoteRepository @Inject constructor(
    retrofitService: RetrofitService,
    val apiCallManager: APICallManager) {

    private val bankService = retrofitService.createService(BankService::class.java)

    suspend fun getBanks(remoteErrorEmitter: RemoteErrorEmitter, paymentMethodId: String): List<BankResponse>? =
        apiCallManager.executeSafeApiCall(remoteErrorEmitter) {
            bankService.getBanks(paymentMethodId = paymentMethodId)
        }

}
