package com.example.freshinthebox.screendisplay

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.freshinthebox.R

data class NamaFood(
    val nama: String,
    val deskripsi: String,
    val gambar: Int
)

val ListFood = listOf(
    NamaFood(nama = "Soto", deskripsi = "Sebuah soto khas Lamongan", gambar = R.drawable.soto),
    NamaFood(nama = "Rawon", deskripsi = "Sebuah makanan berkuah Hytam", gambar = R.drawable.rawon),
    NamaFood(nama = "Ayam Katsu", deskripsi = "Ayam Jepun", gambar = R.drawable.katsu)
)

@Composable
fun FoodCard(fooditem: NamaFood, navKontrol: NavController){
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = { navKontrol.navigate("detailresep")}),
    ){
        Row (modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = fooditem.gambar),
                contentDescription = "Gambar makanan",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .fillMaxSize()
                    .clip(RoundedCornerShape(8.dp))
            )
            Column (modifier = Modifier.padding(16.dp)) {
                Text(
                    text = fooditem.nama,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = fooditem.deskripsi,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
fun FoodList(list: List<NamaFood>){
    val navrem = rememberNavController()
    LazyColumn {
        items(list) {food ->
            FoodCard(fooditem = food, navrem)
        }
    }
}

@Composable
fun FoodScreen(navKontrol: NavController){
    var inputusr by remember { mutableStateOf("") }
    var carifood by remember { mutableStateOf(ListFood) }

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(top = 18.dp, bottom = 18.dp, start = 8.dp, end = 8.dp)
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
        ){
            BackButton(navKontrol)
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Tanya Resep",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color(5,101,38),

            )
            Spacer(modifier = Modifier.weight(1f))
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(color = Color(5,101,38), RoundedCornerShape(50)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = inputusr,
                onValueChange = {
                    inputusr = it
                    carifood = if (inputusr.isNotBlank()) {
                        ListFood.filter { food ->
                            food.nama.contains(inputusr, ignoreCase = true)
                        }
                    } else {
                        emptyList()
                    }},
                label = { Text("Bahan yang kamu punya..")},
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
        Spacer(modifier = Modifier.height(8.dp))
        if (inputusr.isNotBlank())
            FoodList(list = carifood)
    }
}

@Composable
fun BackButton(navController: NavController) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(48.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color = Color(5,101,38))
            .clickable { navController.popBackStack() }
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
            contentDescription = "Kembali",
            tint = Color.White,
            modifier = Modifier.size(48.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DisplayRekom(){
    val navKontrol = rememberNavController()
    FoodScreen(navKontrol)
}