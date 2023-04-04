package br.senai.sp.jandira.mylogin.dao.locais

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.mylogin.R
import br.senai.sp.jandira.mylogin.model.Locais
import br.senai.sp.jandira.mylogin.model.Products

 class LocaisRepository {

    companion object {
        @Composable

        fun getLocaisList(): List <Locais> {
            return listOf <Locais> (
                Locais(
                    id = 1,
                    image = painterResource(id = R.drawable.london),
                    name = "London,2019",
                    description = "London is the capital and largest city of  the United Kingdom, with a population of just under 9 million.",
                    datas = "18 Feb - 21 Feb"
                    ),

                Locais(
                    id = 2,
                    image = painterResource(id = R.drawable.porto),
                    name = "Porto,2022",
                    description = "Porto is the second city in Portugal, the capital of the Oporto District, and one of the Iberian Peninsula's major urban areas.",
                    datas = "20 Feb - 23 Feb"
                )

                )

        }
    }
}

