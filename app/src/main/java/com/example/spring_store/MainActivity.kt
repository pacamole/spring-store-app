package com.example.spring_store

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.spring_store.presentation.cart.CartScreen
import com.example.spring_store.presentation.detail.DetailScreen
import com.example.spring_store.presentation.home.HomeScreen
import com.example.spring_store.presentation.theme.SpringStoreTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContent {
            SpringStoreTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController, startDestination = "home"
                ) {
                    composable("home") {
                        HomeScreen(
                            onProductClick = { product ->
                                navController.navigate("details/${product.id}")
                            },
                            onCartClick = { navController.navigate("cart") }
                        )
                    }
                    composable(
                        route = "details/{productId}",
                        arguments = listOf(navArgument("productId") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val stringId = backStackEntry.arguments?.getString("productId")
                        val productId = stringId?.toLong() ?: 0L

                        DetailScreen(
                            productId = productId, onBackClick = { navController.popBackStack() })
                    }
                    composable(route = "cart") {
                        CartScreen(
                            onBackClick = { navController.popBackStack() },
                            onCartItemClick = {})
                    }
                }
            }
        }
    }
}
