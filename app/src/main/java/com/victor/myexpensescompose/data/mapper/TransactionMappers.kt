package com.victor.myexpensescompose.data.mapper

import com.victor.myexpensescompose.data.local.TransactionEntity
import com.victor.myexpensescompose.domain.model.Transaction

fun TransactionEntity.toDomain(): Transaction = Transaction(
    id = id,
    name = name,
    amount = amount,
    dateMillis = dateMillis,
    //category = category,
    //tag = tag,
    notes = notes
)

fun Transaction.toEntity(): TransactionEntity = TransactionEntity(
    id = id,
    name = name,
    amount = amount,
    dateMillis = dateMillis,
    //category = category,
    //tag = tag,
    notes = notes
)

