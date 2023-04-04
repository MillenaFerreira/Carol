package br.senai.sp.jandira.mylogin.dao.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.mylogin.R
import br.senai.sp.jandira.mylogin.model.Products

class ProductsRepository {
    companion object {
        @Composable
        fun getProductsList(): List<Products> {
            return listOf<Products>(
                Products(
                    id = 1,
                    name = "Montain",
                    image = painterResource(id = R.drawable.montain)

                ),
                Products(
                    id = 2,
                    name = "Snow",
                    image = painterResource(id = R.drawable.snow)

                ),
                Products (
                    id = 3,
                    name = "Beach",
                    image = painterResource(id = R.drawable.beach)
                )

            )


        }
    }
}