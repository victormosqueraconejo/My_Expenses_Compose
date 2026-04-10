package com.victor.myexpensescompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import com.victor.myexpensescompose.data.local.AppDatabase
import com.victor.myexpensescompose.data.repository.TransactionRepositoryImpl
import com.victor.myexpensescompose.presentation.screens.HomeScreen
import com.victor.myexpensescompose.presentation.viewmodel.HomeViewModel
import com.victor.myexpensescompose.presentation.viewmodel.HomeViewModelFactory
import com.victor.myexpensescompose.ui.theme.MyExpensesComposeTheme

class MainActivity : ComponentActivity() {
    private val database: AppDatabase by lazy {
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "expenses.db"
        ).build()
    }

    private val repository by lazy {
        TransactionRepositoryImpl(database.transactionDao())
    }

    private val viewModelFactory by lazy {
        HomeViewModelFactory(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyExpensesComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    val homeViewModel: HomeViewModel = viewModel(factory = viewModelFactory)
                    HomeScreen(viewModel = homeViewModel)
                }
            }
        }
    }
}
