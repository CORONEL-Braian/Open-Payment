package org.techdev.openpayment.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import org.techdev.openpayment.payment.vm.PaymentMethodsVM
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton
import kotlin.reflect.KClass

/**
 * Source:
 *  . https://proandroiddev.com/viewmodel-with-dagger2-architecture-components-2e06f06c9455
 *  . https://stackoverflow.com/a/44639432/5279996
 */
@Singleton
class ViewModelFactory @Inject constructor(
    private val viewModels: MutableMap<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = viewModels[modelClass]?.get() as T

}

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory) : ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PaymentMethodsVM::class)
    internal abstract fun paymentMethodsVM(viewModel: PaymentMethodsVM) : ViewModel

}

@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)