package org.techdev.openpayment.bank.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.techdev.openpayment.bank.data.repository.BankRepositoryImpl
import org.techdev.openpayment.bank.domain.model.BankList
import org.techdev.openpayment.util.OPViewModel
import org.techdev.openpayment.util.ScreenState
import javax.inject.Inject

class BanksVM @Inject constructor(
    private val bankRepositoryImpl: BankRepositoryImpl
) : OPViewModel() {

    private val _banks = MutableLiveData<BankList>()
    val banks: LiveData<BankList> get() = _banks

    fun getBanks(paymentMethodId: String) {
        viewModelScope.launch {
            mutableScreenState.postValue(ScreenState.LOADING)

            val banks = bankRepositoryImpl.getBanks(this@BanksVM, paymentMethodId)
            _banks.postValue(banks)

            val newState = if (banks == null) ScreenState.ERROR else ScreenState.RENDER

            mutableScreenState.postValue(newState)
        }
    }

}