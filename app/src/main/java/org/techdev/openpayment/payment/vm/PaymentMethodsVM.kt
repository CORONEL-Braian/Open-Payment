package org.techdev.openpayment.payment.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.techdev.openpayment.payment.data.repository.PaymentMethodRemoteRepository
import org.techdev.openpayment.payment.data.repository.PaymentMethodRepositoryImpl
import org.techdev.openpayment.payment.domain.model.PaymentMethodList
import org.techdev.openpayment.util.OPViewModel
import org.techdev.openpayment.util.ScreenState
import javax.inject.Inject

class PaymentMethodsVM @Inject constructor(
    private val paymentMethodRepositoryImpl: PaymentMethodRepositoryImpl
) : OPViewModel() {

    private val _paymentMethods = MutableLiveData<PaymentMethodList>()
    val paymentMethods: LiveData<PaymentMethodList> get() = _paymentMethods

    fun getPaymentMethods() {
        viewModelScope.launch {
            mutableScreenState.postValue(ScreenState.LOADING)

            val paymentMethods = paymentMethodRepositoryImpl.getPaymentMethods(this@PaymentMethodsVM)
            _paymentMethods.postValue(paymentMethods)

            val newState = if (paymentMethods == null) ScreenState.ERROR else ScreenState.RENDER

            mutableScreenState.postValue(newState)
        }
    }



}