package org.techdev.openpayment.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import org.techdev.openpayment.HomeActivity

/**
 * OBS: Los módulos por ámbito permiten que esa parte del grafo solo viva durante el tiempo
 * de vida del objeto que lo crea
 */
@Module
interface ActivityModule {

    @ContributesAndroidInjector
    fun contributeHomeActivity(): HomeActivity

}