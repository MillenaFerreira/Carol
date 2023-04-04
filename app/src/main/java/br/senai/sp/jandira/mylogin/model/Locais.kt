package br.senai.sp.jandira.mylogin.model

import androidx.compose.ui.graphics.painter.Painter

data class Locais(
    var id: Int = 0,
    var image: Painter? = null,
    var name : String = "",
    var description : String = "",
    var datas : String = ""
)

