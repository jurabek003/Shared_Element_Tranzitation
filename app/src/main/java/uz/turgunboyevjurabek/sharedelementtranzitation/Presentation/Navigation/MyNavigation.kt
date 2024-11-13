@file:OptIn(ExperimentalSharedTransitionApi::class)

package uz.turgunboyevjurabek.sharedelementtranzitation.Presentation.Navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import uz.turgunboyevjurabek.sharedelementtranzitation.Presentation.Screens.DetailScreen
import uz.turgunboyevjurabek.sharedelementtranzitation.Presentation.Screens.ListScreen
import uz.turgunboyevjurabek.sharedelementtranzitation.utils.SelectedItem

@Composable
fun MyNavigation(navController: NavHostController) {
    SharedTransitionLayout {
        NavHost(navController = navController, startDestination = "list_screen") {
            composable("list_screen") {
                ListScreen(
                    navController = navController,
                    sharedTransitionScope = this@SharedTransitionLayout,
                    animatedContentScope = this@composable,
                )
            }
            composable(
                route = "details/{item}",
                arguments = listOf(navArgument("item") { type = NavType.IntType })
            ) {backStackEntry ->
                val id = backStackEntry.arguments?.getInt("item")
                val snack = SelectedItem.listUser[id!!]
                DetailScreen(
                    id = id,
                    user = snack,
                    navHostController = navController,
                    animatedContentScope = this@composable,
                    sharedTransitionScope = this@SharedTransitionLayout
                )

            }
        }
    }


}