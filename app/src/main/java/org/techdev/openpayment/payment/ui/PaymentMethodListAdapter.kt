package org.techdev.openpayment.payment.ui

import android.annotation.SuppressLint
import android.util.Log
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
import org.techdev.openpayment.payment.domain.model.PaymentMethod

class PaymentMethodListAdapter(val amount: Float) :
    ListAdapter<PaymentMethod, PaymentMethodListAdapter.PaymentMethodViewHolder>(PaymentMethodCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentMethodViewHolder =
        PaymentMethodViewHolder(
            amount,
            LayoutInflater.from(parent.context).inflate(
                R.layout.fragment_payment, parent, false
            )
        )

    override fun onBindViewHolder(holder: PaymentMethodViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    /**
     * PRO: Actualiza el set de items desde un observable
     */
    fun setSubmitList(paymentMethods: List<PaymentMethod>) {
        submitList(paymentMethods)
        notifyDataSetChanged()
    }

    class PaymentMethodViewHolder(val amount: Float, paymentMethodView: View) : RecyclerView.ViewHolder(paymentMethodView) {

        private val image = paymentMethodView.findViewById<ImageView>(R.id.image)
        private val name = paymentMethodView.findViewById<TextView>(R.id.name)

        @SuppressLint("SetTextI18n")
        fun bind(paymentMethod: PaymentMethod) {
            image.loadFromUrl(paymentMethod.secureThumbnail)
            name.text = paymentMethod.name

            itemView.setOnClickListener {
                Navigation.findNavController(it).navigate(
                    R.id.action_paymentFragment_to_banksFragment,
                    PaymentMethodsFragmentDirections.actionPaymentFragmentToBanksFragment(amount, paymentMethod.id).arguments)
            }
        }
    }

}

class PaymentMethodCallback : DiffUtil.ItemCallback<PaymentMethod>() {
    override fun areItemsTheSame(oldItem: PaymentMethod, newItem: PaymentMethod): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: PaymentMethod, newItem: PaymentMethod): Boolean {
        return oldItem == newItem
    }

}