package org.techdev.openpayment.bank.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.techdev.openpayment.R
import org.techdev.openpayment.extensions.loadFromUrl
import org.techdev.openpayment.bank.domain.model.Bank
import org.techdev.openpayment.payment.ui.PaymentMethodsFragmentDirections

class BankListAdapter(val amount: Float, val paymentMethodId: String) :
    ListAdapter<Bank, BankListAdapter.BankViewHolder>(BankCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankViewHolder =
        BankViewHolder(
            amount,
            paymentMethodId,
            LayoutInflater.from(parent.context).inflate(
                R.layout.fragment_bank, parent, false
            )
        )

    override fun onBindViewHolder(holder: BankViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    /**
     * PRO: Actualiza el set de items desde un observable
     */
    fun setSubmitList(banks: List<Bank>) {
        submitList(banks)
        notifyDataSetChanged()
    }

    class BankViewHolder(val amount: Float, val paymentMethodId: String, bankView: View) : RecyclerView.ViewHolder(bankView) {

        private val image = bankView.findViewById<ImageView>(R.id.image)
        private val name = bankView.findViewById<TextView>(R.id.name)

        @SuppressLint("SetTextI18n")
        fun bind(bank: Bank) {
            image.loadFromUrl(bank.secureThumbnail)
            name.text = bank.name

            itemView.setOnClickListener {
                Navigation.findNavController(it).navigate(
                    R.id.action_banksFragment_to_installmentsFragment,
                    BanksFragmentDirections.actionBanksFragmentToInstallmentsFragment(amount, paymentMethodId, bank.id.toInt()).arguments
                )
            }
        }
    }

}

class BankCallback : DiffUtil.ItemCallback<Bank>() {
    override fun areItemsTheSame(oldItem: Bank, newItem: Bank): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Bank, newItem: Bank): Boolean {
        return oldItem == newItem
    }

}