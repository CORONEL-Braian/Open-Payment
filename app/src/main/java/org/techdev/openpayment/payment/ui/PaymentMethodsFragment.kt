package org.techdev.openpayment.payment.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import org.techdev.openpayment.databinding.FragmentPaymentListBinding
import org.techdev.openpayment.payment.vm.PaymentMethodsVM
import org.techdev.openpayment.util.BaseFragment
import javax.inject.Inject

class PaymentMethodsFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: FragmentPaymentListBinding
    private lateinit var paymentMethodsVM: PaymentMethodsVM
    private lateinit var paymentMethodListAdapter: PaymentMethodListAdapter

//    Require Java 1.8
//    private val args: PaymentFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPaymentListBinding.inflate(layoutInflater)

        paymentMethodListAdapter = PaymentMethodListAdapter()

        binding.listRecyclerView.adapter = paymentMethodListAdapter

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        paymentMethodsVM = ViewModelProvider(this, viewModelFactory).get(PaymentMethodsVM::class.java)

        paymentMethodsVM.getPaymentMethods()

        paymentMethodsVM.paymentMethods.observe(viewLifecycleOwner, Observer {
            Log.d("TEST", "" + it?.toString())
            paymentMethodListAdapter.setSubmitList(it.paymentMethods)
        })
    }

}
