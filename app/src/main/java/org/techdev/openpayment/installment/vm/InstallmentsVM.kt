package org.techdev.openpayment.installment.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.techdev.openpayment.installment.data.repository.InstallmentRepositoryImpl
import org.techdev.openpayment.installment.domain.model.Installment
import org.techdev.openpayment.util.OPViewModel
import org.techdev.openpayment.util.ScreenState
import javax.inject.Inject

class InstallmentsVM @Inject constructor(
    private val installmentRepositoryImpl: InstallmentRepositoryImpl
) : OPViewModel() {

    private val _installments = MutableLiveData<Installment>()
    val installments: LiveData<Installment> get() = _installments

    fun getInstallments(paymentMethodId: String) {
        viewModelScope.launch {
            mutableScreenState.postValue(ScreenState.LOADING)

            val installments = installmentRepositoryImpl.getInstallments(this@InstallmentsVM, paymentMethodId)
            _installments.postValue(installments)

            val newState = if (installments == null) ScreenState.ERROR else ScreenState.RENDER

            mutableScreenState.postValue(newState)
        }
    }

}