package org.techdev.openpayment

import android.app.Application
import org.techdev.openpayment.di.AppComponent
import org.techdev.openpayment.di.DaggerAppComponent

/**
 * PRO: Genera el grafo
 */
class OpenPaymentApp: Application() {

//     Reference to the application graph that is used across the whole app
    val appComponent: AppComponent by lazy {    //not run until used
        DaggerAppComponent.create()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }

}