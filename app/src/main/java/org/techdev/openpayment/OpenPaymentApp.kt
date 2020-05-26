package org.techdev.openpayment

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import org.techdev.openpayment.di.DaggerAndroidOpenPaymentComponent

/**
 * PRO: Genera el grafo
 */
class OpenPaymentApp: DaggerApplication()  {

    private val appInjector = DaggerAndroidOpenPaymentComponent.builder()
        .appBind(this)
        .build()

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        appInjector

}