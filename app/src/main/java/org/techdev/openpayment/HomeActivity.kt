package org.techdev.openpayment

import android.os.Bundle
import android.util.Log
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import org.techdev.openpayment.payment.ui.PaymentMethodsFragment
import org.techdev.openpayment.payment.ui.dummy.DummyContent

class HomeActivity : DaggerAppCompatActivity(), PaymentMethodsFragment.OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {
        Log.d("TEST", item?.id.toString())
    }

}