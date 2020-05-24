package org.techdev.openpayment.di

import dagger.Component
import org.techdev.openpayment.OpenPaymentApp
import javax.inject.Singleton

/**
 * Definition of application graph
 * PRE: Necesita un array de módulos a cargar
 */
@Singleton
@Component(modules = [
    AppModule::class
])
interface AppComponent {

    fun inject(openPaymentApp: OpenPaymentApp)

    /**
     * PRO: Indica que al componente de la app se le pueden añadir subcomponentes del home
     */
    fun plus(homeModule: HomeModule): HomeComponent

}