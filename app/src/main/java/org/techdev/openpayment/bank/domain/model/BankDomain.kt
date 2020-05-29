package org.techdev.openpayment.bank.domain.model

data class BankList(
    val banks: List<Bank>
)

data class Bank(
    val id: String,
    val name: String,
    val secureThumbnail: String
)