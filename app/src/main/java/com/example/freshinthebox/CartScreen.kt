package com.example.freshinthebox

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun TransactionHistoryScreen() {
    LazyColumn {
        items(transactionList.size) { transaction ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "Produk: ${transactionList[transaction].namaProduk}")
                Text(text = "Jumlah: ${transactionList[transaction].jumlah}")
                Text(text = "Total Harga: Rp ${transactionList[transaction].totalHarga}")
                Text(text = "Waktu: ${transactionList[transaction].timestamp}")
            }
        }
    }
}
