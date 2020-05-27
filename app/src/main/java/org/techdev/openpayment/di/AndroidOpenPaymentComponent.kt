package org.techdev.openpayment.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import org.techdev.openpayment.OpenPaymentApp
import javax.inject.Singleton

/**
 * Definition of application graph
 * PRE: Necesita un array de módulos a cargar
 * OBS: The android injection modules enable hiding boiler plate code
 *  . AndroidInjectionModule includes binding activity, fragment, service, broadcastReciver and content provider
 *  . Now we extend AndroidInjector there is no need for the inject() function
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AndroidInjectionModule::class,
    ActivityModule::class,
    FragmentModule::class,
    ViewModelModule::class,
    NetworkModule::class
])
interface AndroidOpenPaymentComponent : AndroidInjector<OpenPaymentApp> {

    override fun inject(instance: OpenPaymentApp)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun appBind(openPaymentApp: OpenPaymentApp): Builder

        fun build(): AndroidOpenPaymentComponent

    }

}