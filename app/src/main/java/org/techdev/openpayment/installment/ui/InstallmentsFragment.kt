package org.techdev.openpayment.installment.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import org.techdev.openpayment.databinding.FragmentInstallmentsBinding
import org.techdev.openpayment.installment.vm.InstallmentsVM
import org.techdev.openpayment.util.BaseFragment
import javax.inject.Inject

class InstallmentsFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: FragmentInstallmentsBinding
    private lateinit var installmentsVM: InstallmentsVM
    private lateinit var installmentListAdapter: PayerCostListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInstallmentsBinding.inflate(layoutInflater)

        val args = InstallmentsFragmentArgs.fromBundle(arguments ?: Bundle())
        installmentListAdapter = PayerCostListAdapter(args.amount)

        binding.listRecyclerView.adapter = installmentListAdapter

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        installmentsVM = ViewModelProvider(this, viewModelFactory).get(InstallmentsVM::class.java)

        val args = InstallmentsFragmentArgs.fromBundle(arguments ?: Bundle())

        if (installmentsVM.installments.value == null) {
            installmentsVM.getInstallments(args.bankId)
        }

        installmentsVM.installments.observe(viewLifecycleOwner, Observer {

//            TODO: Si la lista viene vacia voy directamente a InstallmentsFragment
            installmentListAdapter.setSubmitList(it.payerCosts)
        })
    }

}
