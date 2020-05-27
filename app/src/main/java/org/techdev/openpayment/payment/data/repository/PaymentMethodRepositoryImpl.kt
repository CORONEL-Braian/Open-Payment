package org.techdev.openpayment.payment.data.repository

import org.techdev.openpayment.payment.domain.mappers.PaymentMethodMapper
import org.techdev.openpayment.payment.domain.model.PaymentMethodList
import org.techdev.openpayment.util.RemoteErrorEmitter
import javax.inject.Inject

class PaymentMethodRepositoryImpl @Inject constructor(private val remoteRepository: PaymentMethodRepository.RemoteRepository) :
    PaymentMethodRepository {

    override suspend fun getPaymentMethods(remoteErrorEmitter: RemoteErrorEmitter): PaymentMethodList? {
        val response = remoteRepository.getPaymentMethods(remoteErrorEmitter)
        val mapper = PaymentMethodMapper()
        return response?.let {
            mapper.convertFromDataModelToDomain(it)
        }
    }

}