package org.techdev.openpayment.amount

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import org.techdev.openpayment.databinding.FragmentSpecifyAmountBinding

/**
 * A simple [Fragment] subclass.
 */
class SpecifyAmountFragment : Fragment() {

    private lateinit var binding: FragmentSpecifyAmountBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSpecifyAmountBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.paymentMethods.setOnClickListener {
            val amount: Float? = binding.editAmount.text.toString().toFloatOrNull()
            amount?.let {
                if (it > 0) {
                    val action = SpecifyAmountFragmentDirections
                        .actionSpecifyAmountFragmentToPaymentFragment(it)
                    binding.root.findNavController().navigate(action)
                }
            }
        }

    }




}
