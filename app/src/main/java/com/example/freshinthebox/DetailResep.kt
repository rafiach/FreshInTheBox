package com.example.freshinthebox

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.rememberGraphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

data class ResepMasakan (
    val idResep: Int,
    val namaResep: String,
    val gambarResep: Int,
    val bahanResep: List<String>,
    val CaraMemasak: List<String>

)
val reseplList = listOf(
    ResepMasakan(1,"Ayam Katsu",R.drawable.katsu, listOf("1. Ayam", "2. Katsu"), listOf("1. Potong Ayam", "2. Ayam Dikatsu")),
    ResepMasakan(2,"Soto Daging",R.drawable.soto, listOf("1. Soto", "2. Daging"), listOf("1. Rebud Daging", "2. Masukin kuah soto")),
    ResepMasakan(3,"Rawon",R.drawable.rawon, listOf("1. Soto", "2. Daging"), listOf("1. Rebus Daging", "2. Masukin kuah Hytam")),
)


@Composable
fun DetailResepScreen(namaMasakan: String, navController: NavController) {

    val daftarResep = reseplList.find { it.namaResep == namaMasakan }

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        Row (verticalAlignment = Alignment.CenterVertically,
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

        daftarResep?.let { resep ->
            Text(
                text = "Resep ${resep.namaResep}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Green
            )
            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(resep.gambarResep),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )

            Text(
                text = "Bahan",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Green
            )
            Text(
                text = resep.bahanResep.joinToString(separator = "\n"),
                textAlign = TextAlign.Start
            )

            Text(
                text = "Cara Memasak",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Green
            )
            Text(
                text = resep.CaraMemasak.joinToString(separator = "\n"),
                textAlign = TextAlign.Start
            )
        } ?: run {
            Text(text = "Resep tidak ditemukan", fontSize = 16.sp, color = Color.Red)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Displayresep(){
    val navkon = rememberNavController()
    DetailResepScreen("Rawon", navkon)
}