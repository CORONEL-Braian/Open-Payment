package org.techdev.openpayment.bank.data.repository

import org.techdev.openpayment.bank.domain.mappers.BankMapper
import org.techdev.openpayment.bank.domain.model.BankList
import org.techdev.openpayment.util.RemoteErrorEmitter
import javax.inject.Inject

class BankRepositoryImpl
@Inject
constructor(private val remoteRepository: BankRemoteRepository) {

    suspend fun getBanks(remoteErrorEmitter: RemoteErrorEmitter, paymentMethodId: String): BankList? {
        val response = remoteRepository.getBanks(remoteErrorEmitter, paymentMethodId)
        val mapper = BankMapper()
        return response?.let {
            mapper.convertFromDataModelToDomain(it)
        }
    }

}
