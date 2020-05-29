package org.techdev.openpayment.di

import dagger.Module
import dagger.Provides
import org.techdev.openpayment.bank.data.repository.BankRemoteRepository
import org.techdev.openpayment.bank.data.repository.BankRepositoryImpl
import org.techdev.openpayment.data.network.APICallManager
import org.techdev.openpayment.data.network.RetrofitService
import org.techdev.openpayment.installment.data.repository.InstallmentRemoteRepository
import org.techdev.openpayment.installment.data.repository.InstallmentRepositoryImpl
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

    @Singleton
    @Provides
    @Remote
    fun contributeBankRemoteRepository(
        retrofitService: RetrofitService,
        apiCallManager: APICallManager): BankRemoteRepository {
        return BankRemoteRepository(retrofitService, apiCallManager)
    }

    @Singleton
    @Provides
    @Remote
    fun contributeBankRepositoryImpl(
        remoteRepository: BankRemoteRepository
    ): BankRepositoryImpl {
        return BankRepositoryImpl(remoteRepository)
    }

    @Singleton
    @Provides
    @Remote
    fun contributeInstallmentRemoteRepository(
        retrofitService: RetrofitService,
        apiCallManager: APICallManager): InstallmentRemoteRepository {
        return InstallmentRemoteRepository(retrofitService, apiCallManager)
    }

    @Singleton
    @Provides
    @Remote
    fun contributeInstallmentRepositoryImpl(
        remoteRepository: InstallmentRemoteRepository
    ): InstallmentRepositoryImpl {
        return InstallmentRepositoryImpl(remoteRepository)
    }

}

annotation class Remote