    package com.example.freshinthebox.screendisplay

    import androidx.compose.foundation.Image
    import androidx.compose.foundation.background
    import androidx.compose.foundation.clickable
    import androidx.compose.foundation.layout.*
    import androidx.compose.foundation.lazy.LazyRow
    import androidx.compose.foundation.lazy.grid.GridCells
    import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
    import androidx.compose.foundation.shape.CircleShape
    import androidx.compose.foundation.shape.RoundedCornerShape
    import androidx.compose.material3.*
    import androidx.compose.material.icons.Icons
    import androidx.compose.material.icons.filled.Search
    import androidx.compose.runtime.*
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
    import com.example.freshinthebox.Category
    import com.example.freshinthebox.Product
    import com.example.freshinthebox.component.CategoryCard
    import com.example.freshinthebox.component.ProductCard
    import com.example.freshinthebox.getSampleCategories
    import com.example.freshinthebox.getSampleProducts


    @Composable
    fun HomeScreen(navkontrol: NavController) {
        val categories = getSampleCategories()
        val products = getSampleProducts()

        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Hi, Fifrens...",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(44, 110, 73),
                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))

            SearchBar()

            Text(
                text = "Kategori",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(44, 110, 73),
                modifier = Modifier.padding(16.dp)
            )
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(
                    Color(254, 254, 227),
                    RoundedCornerShape(16.dp)
                )
            ){
                LazyRow(modifier = Modifier.padding(horizontal = 8.dp)) {
                    items(categories.size) { index ->
                        CategoryCard(category = categories[index])
                    }
                }
            }

            Text(
                text = "Produk",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(44, 110, 73),
                modifier = Modifier.padding(16.dp)
            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                items(products.size) { index ->
                    ProductCard(product = products[index], onClick = {
                        navkontrol.navigate("detailproduk/${products[index].id}")
                    })
                }
            }
        }
    }

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
                label = { Text("Mau mamam apa hari ini ?")},
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

    @Preview(showBackground = true)
    @Composable
    fun DisplayBeranda(){
        val navKontrol = rememberNavController()
        HomeScreen(navKontrol)
    }