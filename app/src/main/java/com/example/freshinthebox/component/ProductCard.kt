package com.example.freshinthebox.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.freshinthebox.Product

@Composable
fun ProductCard(product: Product, onClick: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(160.dp)
            .height(230.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable{onClick(product.id)},
        colors = CardDefaults.cardColors(
            containerColor = Color(44, 110, 73)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = product.name,
                modifier = Modifier
                    .size(172.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
            )
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .align(Alignment.Start),
            ) {
                Text(text = product.name, fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.Bold)
                Text(text = product.price, fontSize = 16.sp, color = Color.White)
            }
        }
    }
}
