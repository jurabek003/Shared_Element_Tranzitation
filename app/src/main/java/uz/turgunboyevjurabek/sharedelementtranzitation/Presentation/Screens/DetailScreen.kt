
package uz.turgunboyevjurabek.sharedelementtranzitation.Presentation.Screens

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import uz.turgunboyevjurabek.sharedelementtranzitation.Domein.madels.User
import uz.turgunboyevjurabek.sharedelementtranzitation.utils.SelectedItem

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun DetailScreen(
    id: Int,
    user: User,
    navHostController: NavHostController,
    sharedTransitionScope: SharedTransitionScope,
    animatedContentScope: AnimatedContentScope,
) {
    with(sharedTransitionScope){
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = user.image),
                contentDescription =null,
                modifier = Modifier
                    .aspectRatio(1f)
                    .sharedElement(
                        sharedTransitionScope.rememberSharedContentState(key = "image-$id"),
                        animatedVisibilityScope = animatedContentScope,
                        boundsTransform = { initialBounds, targetBounds ->
                            spring(
                                dampingRatio = 0.8f,
                                stiffness = 380f
                            )
                        },
                    )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = user.name,
                modifier = Modifier
                    .sharedElement(
                        sharedTransitionScope.rememberSharedContentState(key = "text-$id"),
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