package org.techdev.openpayment.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import org.techdev.openpayment.bank.vm.BanksVM
import org.techdev.openpayment.installment.vm.InstallmentsVM
import org.techdev.openpayment.payment.vm.PaymentMethodsVM

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PaymentMethodsVM::class)
    abstract fun bindPaymentMethodsVM(paymentMethodsVM: PaymentMethodsVM): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BanksVM::class)
    abstract fun bindBanksVM(banksVM: BanksVM): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(InstallmentsVM::class)
    abstract fun bindInstallmentsVM(installmentsVM: InstallmentsVM): ViewModel

}