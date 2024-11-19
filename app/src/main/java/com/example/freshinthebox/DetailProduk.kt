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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.freshinthebox.component.AddStatusCart
import com.example.freshinthebox.component.TopBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(navkontrol: NavController, productId: Int) {
    val product = getSampleProducts().find { it.id == productId }
    var jumlahProduk by remember{ mutableStateOf(1)}


    if (product != null){
        Scaffold (
            topBar = {
                TopBar(navkontrol, "Detail Produk")
            },
            bottomBar = {
                AddStatusCart(jumlahProduk, product.price, {
                    saveTransaction(product.name, jumlahProduk, product.price.toDouble()*jumlahProduk)
                    navkontrol.navigate("cart")
                })
            }
        ){ paddingValues ->

            Column(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
                Image(
                    painter = painterResource(id = product.imageRes),
                    contentDescription = "Gambar Produk",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(240.dp)
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .background(Color.White, RoundedCornerShape(8.dp)),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Column {
                        Text(text = product.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Text(text = product.price.toString(), fontSize = 18.sp)
                    }
                    Row (verticalAlignment = Alignment.CenterVertically){
                        IconButton(onClick = {
                            if (jumlahProduk > 1) jumlahProduk--
                        }) {
                            Text(text = "-", fontSize = 24.sp)
                        }
                        Text(text = jumlahProduk.toString(), fontSize = 24.sp)
                        IconButton(onClick = {
                            jumlahProduk++
                        }) {
                            Text(text = "+", fontSize = 24.sp)
                        }
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