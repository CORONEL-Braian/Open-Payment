package org.techdev.openpayment.payment.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import org.techdev.openpayment.R
import org.techdev.openpayment.di.DaggerViewModelFactory
import org.techdev.openpayment.di.ViewModelFactoryModule
import org.techdev.openpayment.payment.ui.dummy.DummyContent
import org.techdev.openpayment.payment.ui.dummy.DummyContent.DummyItem
import org.techdev.openpayment.payment.vm.PaymentMethodsVM
import org.techdev.openpayment.util.BaseFragment
import javax.inject.Inject

class PaymentMethodsFragment : BaseFragment() {

    private var columnCount = 1

    private var listener: OnListFragmentInteractionListener? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var paymentMethodsVM: PaymentMethodsVM /*by viewModels {
        viewModelFactory
    }*/

//    Require Java 1.8
//    private val args: PaymentFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_payment_list, container, false)



        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MyPaymentRecyclerViewAdapter(DummyContent.ITEMS, listener)
            }
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        paymentMethodsVM = ViewModelProvider(this, viewModelFactory).get(PaymentMethodsVM::class.java)

        paymentMethodsVM.getPaymentMethods()

        paymentMethodsVM.paymentMethods.observe(viewLifecycleOwner, Observer {
            Log.d("TEST", "" + it?.toString())
        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: DummyItem?)
    }

}
