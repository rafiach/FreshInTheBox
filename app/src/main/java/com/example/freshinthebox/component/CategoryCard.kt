package com.example.freshinthebox.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.freshinthebox.Category
import com.example.freshinthebox.R

@Composable
fun CategoryCard(category: Category) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(100.dp)
            .height(130.dp)
            .clip(RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(
            containerColor = Color(44, 110, 73)
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = category.imageRes),
                contentDescription = category.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp))
            )
            Text(
                text = category.name,
                fontSize = 12.sp,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewCategorycard() {
//    Categorycard(
//        title = "Kucing Keren",
//        image = painterResource(id = R.drawable.cat),
//        onClick = { /* No action in preview */ }
//    )
//}