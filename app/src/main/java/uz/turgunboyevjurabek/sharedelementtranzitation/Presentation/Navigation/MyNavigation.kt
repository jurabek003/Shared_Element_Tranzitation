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

@Composable
fun MyNavigation(navController: NavHostController) {

    SharedTransitionLayout {
        NavHost(navController = navController, startDestination = "list_screen") {
            composable("list_screen") {
                ListScreen(
                    onItemClick = {imageId,text->
                        navController.navigate("detail_screen/$imageId/$text")
                    },
                    animatedVisibilityScope = this
                )
            }


            composable(route = "detail_screen/{imageId}/{text}",
                arguments = listOf(
                    navArgument(name = "imageId"){
                        type = NavType.IntType
                    },
                    navArgument(name = "text") {
                        type = NavType.StringType
                    }
                )
            ){
                val imageId = it.arguments?.getInt("imageId")
                val text = it.arguments?.getString("text")
                DetailScreen(imageId = imageId!!, text = text!!, animatedVisibilityScope = this)

            }
        }
    }


}