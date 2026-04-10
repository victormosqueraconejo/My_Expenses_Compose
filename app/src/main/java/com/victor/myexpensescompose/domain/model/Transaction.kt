package com.victor.myexpensescompose.domain.model

import com.victor.myexpensescompose.Category
import com.victor.myexpensescompose.Tags

data class Transaction(
    val id: Long = 0,
    val name: String,
    val amount: Double,
    val dateMillis: Long,
    val category: Category,
    val tag: Tags,
    val notes: String? = null
)

