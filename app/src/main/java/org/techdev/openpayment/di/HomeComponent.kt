package org.techdev.openpayment.di

import dagger.Subcomponent
import org.techdev.openpayment.HomeActivity
import javax.inject.Singleton

/**
 * PRO: Indica que se va a inyectar en la HomeActivity
 * Source: https://stackoverflow.com/a/48475521/5279996
 */
@Subcomponent(modules = [
    HomeModule::class
])
interface HomeComponent {
    fun inject(activity: HomeActivity)
}