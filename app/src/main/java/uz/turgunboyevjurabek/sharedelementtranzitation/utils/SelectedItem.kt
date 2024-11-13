package uz.turgunboyevjurabek.sharedelementtranzitation.utils

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import uz.turgunboyevjurabek.sharedelementtranzitation.Domein.madels.User
import uz.turgunboyevjurabek.sharedelementtranzitation.R

object SelectedItem {
    var image: Int? = null
    var name:String? = null
    val listUser= listOf(
        User(name = "Jurabek", image = R.drawable.image1),
        User(name = "Shukurullo", image = R.drawable.image2),
        User(name = "Sirojiddin", image = R.drawable.image3),
    )
}