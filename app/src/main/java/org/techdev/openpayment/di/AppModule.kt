package org.techdev.openpayment.di

import dagger.Module
import dagger.Provides
import org.techdev.openpayment.OpenPaymentApp
import javax.inject.Singleton

@Module
class AppModule(private val app: OpenPaymentApp) {

    @Provides
    @Singleton
    fun provideApp() = app

}