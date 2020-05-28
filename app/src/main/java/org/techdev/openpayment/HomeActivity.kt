package org.techdev.openpayment

import android.os.Bundle
import dagger.android.AndroidInjection
import org.techdev.openpayment.util.BaseActivity

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

}