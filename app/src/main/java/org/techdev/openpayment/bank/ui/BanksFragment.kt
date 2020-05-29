package org.techdev.openpayment.bank.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import org.techdev.openpayment.databinding.FragmentBankListBinding
import org.techdev.openpayment.bank.vm.BanksVM
import org.techdev.openpayment.payment.ui.PaymentMethodsFragmentArgs
import org.techdev.openpayment.util.BaseFragment
import javax.inject.Inject

class BanksFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: FragmentBankListBinding
    private lateinit var banksVM: BanksVM
    private lateinit var bankListAdapter: BankListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBankListBinding.inflate(layoutInflater)

        val args = PaymentMethodsFragmentArgs.fromBundle(arguments ?: Bundle())
        bankListAdapter = BankListAdapter(args.amount)

        binding.listRecyclerView.adapter = bankListAdapter

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        banksVM = ViewModelProvider(this, viewModelFactory).get(BanksVM::class.java)

        val args = BanksFragmentArgs.fromBundle(arguments ?: Bundle())

        if (banksVM.banks.value == null) {
            banksVM.getBanks(args.paymentMethodId)
        }

        banksVM.banks.observe(viewLifecycleOwner, Observer {
            bankListAdapter.setSubmitList(it.banks)
        })
    }

}
