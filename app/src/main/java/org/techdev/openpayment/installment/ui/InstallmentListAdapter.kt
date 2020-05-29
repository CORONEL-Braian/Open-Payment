package org.techdev.openpayment.installment.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.techdev.openpayment.R
import org.techdev.openpayment.installment.domain.model.PayerCost

class PayerCostListAdapter(val amount: Float, val paymentMethodId: String) :
    ListAdapter<PayerCost, PayerCostListAdapter.PayerCostViewHolder>(PayerCostCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PayerCostViewHolder =
        PayerCostViewHolder(
            amount,
            paymentMethodId,
            LayoutInflater.from(parent.context).inflate(
                R.layout.fragment_payer_cost, parent, false
            )
        )

    override fun onBindViewHolder(holder: PayerCostViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    /**
     * PRO: Actualiza el set de items desde un observable
     */
    fun setSubmitList(payerCosts: List<PayerCost>) {
        submitList(payerCosts)
        notifyDataSetChanged()
    }

    class PayerCostViewHolder(val amount: Float, val paymentMethodId: String, payerCostView: View) : RecyclerView.ViewHolder(payerCostView) {

        private val labels = payerCostView.findViewById<TextView>(R.id.labels)
        private val recommendedMessage = payerCostView.findViewById<TextView>(R.id.recommendedMessage)

        @SuppressLint("SetTextI18n")
        fun bind(payerCost: PayerCost) {
            labels.text = payerCost.labels[0]
            recommendedMessage.text = payerCost.recommendedMessage

            itemView.setOnClickListener {
//                TODO: Seguir el flujo
            }
        }
    }

}

class PayerCostCallback : DiffUtil.ItemCallback<PayerCost>() {
    override fun areItemsTheSame(oldItem: PayerCost, newItem: PayerCost): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: PayerCost, newItem: PayerCost): Boolean {
        return oldItem == newItem
    }

}