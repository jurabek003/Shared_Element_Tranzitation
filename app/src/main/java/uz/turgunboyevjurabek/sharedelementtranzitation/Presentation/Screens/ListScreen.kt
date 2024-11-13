package uz.turgunboyevjurabek.sharedelementtranzitation.Presentation.Screens

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import uz.turgunboyevjurabek.sharedelementtranzitation.R
import uz.turgunboyevjurabek.sharedelementtranzitation.utils.SelectedItem

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun ListScreen(
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope,
    navController: NavHostController,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)

    ) {
        itemsIndexed(SelectedItem.listUser) { index, item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate("details/$index")
                    }
            ) {
                with(sharedTransitionScope){
                    Image(
                        painter = painterResource(id = item.image),
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                            .sharedElement(
                                sharedTransitionScope.rememberSharedContentState(key = "image-$index"),
                                animatedVisibilityScope = animatedContentScope,
                                boundsTransform = { initialBounds, targetBounds ->
                                    spring(
                                        dampingRatio = 0.8f,
                                        stiffness = 380f
                                    )
                                },
                            )
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                with(sharedTransitionScope){
                    Text(
                        text = item.name,
                        modifier = Modifier
                            .sharedElement(
                                sharedTransitionScope.rememberSharedContentState(key = "text-$index"),
                                animatedVisibilityScope = animatedContentScope,
                                boundsTransform = { initialBounds, targetBounds ->
                                    spring(
                                        dampingRatio = 0.8f,
                                        stiffness = 380f
                                    )
                                },
                            )
                    )

                }

            }

        }
    }


}