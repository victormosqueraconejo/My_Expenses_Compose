package com.victor.myexpensescompose.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.victor.myexpensescompose.Category
import com.victor.myexpensescompose.Tags

@Entity(tableName = "transactions")
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val amount: Double,
    val dateMillis: Long,
    val category: Category,
    val tag: Tags,
    val notes: String? = null
)

