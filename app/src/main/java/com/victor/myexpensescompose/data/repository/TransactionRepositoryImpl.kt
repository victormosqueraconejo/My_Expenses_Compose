package com.victor.myexpensescompose.data.repository

import com.victor.myexpensescompose.data.local.TransactionDao
import com.victor.myexpensescompose.data.mapper.toDomain
import com.victor.myexpensescompose.data.mapper.toEntity
import com.victor.myexpensescompose.domain.model.Transaction
import com.victor.myexpensescompose.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TransactionRepositoryImpl(
    private val dao: TransactionDao
) : TransactionRepository {
    override fun observeTransactions(): Flow<List<Transaction>> =
        dao.observeAll().map { entities -> entities.map { it.toDomain() } }

    override suspend fun addTransaction(transaction: Transaction) {
        dao.insert(transaction.toEntity())
    }
}

