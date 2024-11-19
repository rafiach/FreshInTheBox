package com.example.freshinthebox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.freshinthebox.component.BottomNavBar
import androidx.compose.runtime.getValue
import androidx.navigation.NavType
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.example.freshinthebox.component.SplashScreen
import com.example.freshinthebox.login.LoginScreen
import com.example.freshinthebox.login.RegisterScreen
import com.example.freshinthebox.screendisplay.CategoriesScreen
import com.example.freshinthebox.screendisplay.FoodScreen
import com.example.freshinthebox.screendisplay.HomeScreen
import com.example.freshinthebox.screendisplay.ProfileScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute !in listOf("splash", "login", "register")) {
                BottomNavBar(navController)
            }
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = "beranda", Modifier.padding(innerPadding)) {
            val namaResep= "Rawon"
            composable("splash") { SplashScreen(navController) }
            composable("login") { LoginScreen(navController) }
            composable("register") { RegisterScreen(navController) }
            composable("kategori") { CategoriesScreen(navController) }
            composable("resep") { FoodScreen(navController) }
            composable("beranda") { HomeScreen(navController) }
            composable("profil") { ProfileScreen(navController) }
            composable(
                "detailproduk/{productId}",
                arguments = listOf(navArgument("productId") { type = NavType.IntType })
            ) { backStackEntry ->
                val productId = backStackEntry.arguments?.getInt("productId") ?: 0
                ProductDetailScreen(navController,productId)
            }
//            untuk ke detail resep kan butuh parameter resepmasakan nah untuk dinavhost belum bisa, jadi ini pakek dummy nama resep hehe
            composable("detailresep") { DetailResepScreen(namaResep,navController) }
            composable("cart") { TransactionHistoryScreen() }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}
