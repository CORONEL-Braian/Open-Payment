package org.techdev.openpayment.di

import dagger.Module
import org.techdev.openpayment.HomeActivity

/**
 * PRO: Describe un subgrafo que vive y muere con HomeActivity. Además contiene lo que se necesite
 * OBS: Los módulos por ámbito permiten que esa parte del grafo solo viva durante el tiempo
 * de vida del objeto que lo crea
 */
@Module
class HomeModule(val activity: HomeActivity) {


}