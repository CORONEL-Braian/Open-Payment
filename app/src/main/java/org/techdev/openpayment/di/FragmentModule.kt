package org.techdev.openpayment.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import org.techdev.openpayment.amount.SpecifyAmountFragment
import org.techdev.openpayment.payment.ui.PaymentMethodsFragment

@Module
interface FragmentModule {

    @ContributesAndroidInjector
    fun specifyAmountFragment(): SpecifyAmountFragment

    @ContributesAndroidInjector
    fun paymentMethodsFragment(): PaymentMethodsFragment

}