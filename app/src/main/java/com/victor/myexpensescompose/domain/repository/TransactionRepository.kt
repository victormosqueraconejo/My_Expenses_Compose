package com.victor.myexpensescompose.domain.repository

import com.victor.myexpensescompose.domain.model.Transaction
import kotlinx.coroutines.flow.Flow

interface TransactionRepository {
    fun observeTransactions(): Flow<List<Transaction>>
    suspend fun addTransaction(transaction: Transaction)
}

