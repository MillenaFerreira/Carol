package br.senai.sp.jandira.mylogin.model

import android.media.Image
import androidx.compose.ui.graphics.painter.Painter

data class Products(
    var id: Int = 0,
    var name : String = "",
    var image: Painter? = null

)


