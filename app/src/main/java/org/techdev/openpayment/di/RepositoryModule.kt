package org.techdev.openpayment.di

import dagger.Module
import dagger.Provides
import org.techdev.openpayment.data.network.APICallManager
import org.techdev.openpayment.data.network.RetrofitService
import org.techdev.openpayment.payment.data.repository.*
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    @Remote
    fun contributePaymentMethodRemoteRepository(
        retrofitService: RetrofitService,
        apiCallManager: APICallManager): PaymentMethodRemoteRepository {
        return PaymentMethodRemoteRepository(retrofitService, apiCallManager)
    }

    @Singleton
    @Provides
    @Remote
    fun contributePaymentMethodRepositoryImpl(
        remoteRepository: PaymentMethodRemoteRepository
    ): PaymentMethodRepositoryImpl {
        return PaymentMethodRepositoryImpl(remoteRepository)
    }


}

annotation class Remote