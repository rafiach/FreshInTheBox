package com.example.freshinthebox.screendisplay

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.freshinthebox.R

@Composable
fun CategoriesScreen(navController: NavController) {
    val kategoriList = listOf(
        Kategori("Sayuran", R.drawable.sayuran),
        Kategori("Buah", R.drawable.buah),
        Kategori("Daging", R.drawable.daging),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Categories",
            style = MaterialTheme.typography.titleMedium,
            color = Color(0xFF006400)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Bar pencarian
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF006400), RoundedCornerShape(8.dp))
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Search", color = Color.White, modifier = Modifier.weight(1f))
            Icon(imageVector = Icons.Filled.Search, contentDescription = "Search Icon", tint = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // List Kategori
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(kategoriList) { kategori ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF006400), RoundedCornerShape(8.dp))
                        .clickable {
                            navController.navigate("kategori/${kategori.nama}")
                        }
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = kategori.nama,
                        color = Color.White,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

data class Kategori(val nama: String, val image: Int) {

}
