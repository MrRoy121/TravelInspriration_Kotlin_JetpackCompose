import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.travelinspirations.HomeScreen
import androidx.navigation.NavType
import com.example.travelinspirations.Destination
import com.example.travelinspirations.DestinationDao
import com.example.travelinspirations.DestinationDetailsScreen
import com.example.travelinspirations.FavoritesScreen
import com.example.travelinspirations.ProfileScreen
import com.example.travelinspirations.SettingsScreen

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun TravelApp(destinationDao: DestinationDao) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "home") {
        composable("home") {
            HomeScreen(destinations = destinationDao.getAll()) { destination ->
                navController.navigate("details/${destination.id}")
            }
        }
        composable(
            "details/{destinationId}",
            arguments = listOf(navArgument("destinationId") { type = NavType.IntType })
        ) { backStackEntry ->
            val destinationId = backStackEntry.arguments?.getInt("destinationId")
            val destination = destinationDao.getById(destinationId ?: 0)
            destination?.let {
                DestinationDetailsScreen(it)
            }
        }
        composable("favorites") {
            FavoritesScreen(favorites = destinationDao.getFavorites()) { destination ->
                navController.navigate("details/${destination.id}")
            }
        }
        composable("profile") {
            ProfileScreen(userName = "John Doe")
        }
        composable("settings") {
            SettingsScreen()
        }
    }
}
