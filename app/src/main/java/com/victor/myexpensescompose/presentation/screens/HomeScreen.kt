package com.victor.myexpensescompose.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.victor.myexpensescompose.R
import com.victor.myexpensescompose.domain.model.Transaction
import com.victor.myexpensescompose.presentation.viewmodel.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
	viewModel: HomeViewModel,
	modifier: Modifier = Modifier
) {
	val uiState by viewModel.uiState.collectAsState()

	Scaffold(
		modifier = modifier.fillMaxSize(),
		topBar = {
			TopAppBar(
				title = { Text(text = stringResource(id = R.string.app_name)) }
			)
		},
		floatingActionButton = {
			FloatingActionButton(
				onClick = { /* TODO: Agregar nueva transaccion */ }
			) {
				Icon(Icons.Default.Add, contentDescription = "Agregar")
			}
		}
	) { paddingValues ->
		if (uiState.transactions.isEmpty()) {
			Text(
				text = "Sin movimientos",
				modifier = Modifier.padding(paddingValues).padding(16.dp)
			)
		} else {
			TransactionList(
				items = uiState.transactions,
				contentPadding = paddingValues
			)
		}
	}
}

@Composable
private fun TransactionList(
	items: List<Transaction>,
	contentPadding: PaddingValues
) {
	LazyColumn(
		contentPadding = contentPadding,
		verticalArrangement = Arrangement.spacedBy(12.dp),
		modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp, vertical = 12.dp)
	) {
		items(items, key = { it.id }) { item ->
			Text(text = "${item.name}: $${item.amount}")
		}
	}
}