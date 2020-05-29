package org.techdev.openpayment.bank.domain.mappers

import org.techdev.openpayment.bank.data.repository.BankResponse
import org.techdev.openpayment.bank.domain.model.Bank
import org.techdev.openpayment.bank.domain.model.BankList

/**
 * Maps the data to the domain model
 */
class BankMapper {

    fun convertFromDataModelToDomain(banksResponse: List<BankResponse>) : BankList =
        BankList(
            convertBankListToDomain(banksResponse)
        )

    /**
     * Convert the bank method list from the data to the domain model
     */
    private fun convertBankListToDomain(list: List<BankResponse>) : List<Bank> {
        return list.mapIndexed { _, bankResponse ->
            convertBankItemToDomain(bankResponse)
        }
    }

    private fun convertBankItemToDomain(bankResponse: BankResponse) : Bank {
        return Bank(
            bankResponse.id,
            bankResponse.name,
            bankResponse.secureThumbnail
        )
    }

}