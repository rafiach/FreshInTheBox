package com.example.freshinthebox

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(navkontrol: NavController, productId: Int) {
    val product = getSampleProducts().find { it.id == productId }

    if (product != null){
        Column(modifier = Modifier.fillMaxSize()) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 16.dp)
            ){
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(color = Color(5,101,38))
                        .clickable { navkontrol.popBackStack() }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = "Kembali",
                        tint = Color.White,
                        modifier = Modifier.size(48.dp)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Detail Produk",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color(5,101,38),

                    )
                Spacer(modifier = Modifier.weight(1f))
            }
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = "Gambar Produk",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = product.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text(text = product.price, fontSize = 18.sp)
                }
                Row {
                    IconButton(onClick = { /* Action untuk kurang */ }) {
                        Text(text = "-", fontSize = 24.sp)
                    }
                    Text(text = "1", fontSize = 24.sp) // Ganti dengan state jumlah
                    IconButton(onClick = { /* Action untuk tambah */ }) {
                        Text(text = "+", fontSize = 24.sp)
                    }
                }
            }
        }
    } else{
        Text(text = "Produk tidak ditemukan", color = Color.Red)
    }
}


@Preview(showBackground = true)
@Composable
fun dis(){
    val kontrol = rememberNavController()
    ProductDetailScreen( kontrol, 1)
}