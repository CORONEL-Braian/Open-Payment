package org.techdev.openpayment.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import org.techdev.openpayment.amount.SpecifyAmountFragment
import org.techdev.openpayment.bank.ui.BanksFragment
import org.techdev.openpayment.payment.ui.PaymentMethodsFragment
import org.techdev.openpayment.installment.ui.InstallmentsFragment

@Module
interface FragmentModule {

    @ContributesAndroidInjector
    fun specifyAmountFragment(): SpecifyAmountFragment

    @ContributesAndroidInjector
    fun paymentMethodsFragment(): PaymentMethodsFragment

    @ContributesAndroidInjector
    fun banksFragment(): BanksFragment

    @ContributesAndroidInjector
    fun installmentsFragment(): InstallmentsFragment

}