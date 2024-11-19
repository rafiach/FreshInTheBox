package com.example.freshinthebox.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.freshinthebox.screendisplay.ListFood

@Composable
fun SearchBar() {
    var inputusr by remember { mutableStateOf("") }
    var carifood by remember { mutableStateOf(ListFood) }
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(color = Color(44, 110, 73), RoundedCornerShape(50)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = inputusr,
            onValueChange = { inputusr = it },
            label = { Text("Mau mamam apa hari ini ?") },
            modifier = Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(50))
                .height(48.dp)
                .width(300.dp)
                .background(color = Color.Transparent)
        )
        Box(
            modifier = Modifier
                .padding(8.dp)
                .size(48.dp,48.dp)
                .background(color = Color.Transparent, shape = CircleShape)
                .clickable(onClick = {
                    carifood = if (inputusr.isNotBlank()) {
                        ListFood.filter { food ->
                            food.nama.contains(inputusr, ignoreCase = true)
                        }
                    } else {
                        emptyList()
                    }
                }),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Cari",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
