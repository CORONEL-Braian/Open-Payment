package org.techdev.openpayment.installment.data.repository

import org.techdev.openpayment.installment.domain.mappers.InstallmentMapper
import org.techdev.openpayment.installment.domain.model.Installment
import org.techdev.openpayment.util.RemoteErrorEmitter
import javax.inject.Inject

class InstallmentRepositoryImpl
@Inject
constructor(private val remoteRepository: InstallmentRemoteRepository) {

    suspend fun getInstallments(remoteErrorEmitter: RemoteErrorEmitter, paymentMethodId: String): Installment? {
        val response = remoteRepository.getInstallments(remoteErrorEmitter, paymentMethodId)
        val mapper = InstallmentMapper()
        return response?.let {
            mapper.convertFromDataModelToDomain(it)
        }
    }

}
