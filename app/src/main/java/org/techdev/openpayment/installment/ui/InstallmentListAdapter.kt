package org.techdev.openpayment.installment.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.techdev.openpayment.R
import org.techdev.openpayment.installment.domain.model.PayerCost

class PayerCostListAdapter(val amount: Float) :
    ListAdapter<PayerCost, PayerCostListAdapter.PayerCostViewHolder>(PayerCostCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PayerCostViewHolder =
        PayerCostViewHolder(
            amount,
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

    class PayerCostViewHolder(val amount: Float, payerCostView: View) : RecyclerView.ViewHolder(payerCostView) {

        private val image = payerCostView.findViewById<ImageView>(R.id.image)
        private val name = payerCostView.findViewById<TextView>(R.id.name)

        @SuppressLint("SetTextI18n")
        fun bind(payerCost: PayerCost) {
    /*        image.loadFromUrl(payerCost.secureThumbnail)
            name.text = payerCost.name*/

            itemView.setOnClickListener {

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