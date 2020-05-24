package org.techdev.openpayment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.techdev.openpayment.di.HomeModule
import org.techdev.openpayment.extensions.app

class HomeActivity : AppCompatActivity() {

//    Subcomponente
    val homeComponent by lazy {
        app.appComponent.plus(HomeModule(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        homeComponent.inject(this)
        Log.d("Test", "Hi")
    }
}