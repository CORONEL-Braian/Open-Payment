package org.techdev.openpayment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import org.techdev.openpayment.di.HomeModule
import org.techdev.openpayment.extensions.app
import org.techdev.openpayment.payment.ui.PaymentFragment
import org.techdev.openpayment.payment.ui.dummy.DummyContent

class HomeActivity : AppCompatActivity(), PaymentFragment.OnListFragmentInteractionListener {

//    Subcomponente
    val homeComponent by lazy {
        app.appComponent.plus(HomeModule(this))
    }

    private var paymentFragment: PaymentFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        homeComponent.inject(this)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.payment_methods_container, paymentFragmentProvider())
            .commit()

    }

    private fun paymentFragmentProvider(): Fragment {
        if (paymentFragment == null) {
            paymentFragment = PaymentFragment()
        }
        return paymentFragment as PaymentFragment
    }

    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {

    }

}