package com.victor.myexpensescompose.domain.model

data class Transaction(
    val id: Long = 0,
    val name: String,
    val amount: Double,
    val dateMillis: Long,
    //val category: Category,
    //val tag: Tags,
    val notes: String? = null
)

