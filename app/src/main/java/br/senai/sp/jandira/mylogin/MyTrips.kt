package br.senai.sp.jandira.mylogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.mylogin.dao.locais.LocaisRepository
import br.senai.sp.jandira.mylogin.dao.repository.ProductsRepository
import br.senai.sp.jandira.mylogin.model.Locais
import br.senai.sp.jandira.mylogin.model.Products
import br.senai.sp.jandira.mylogin.ui.theme.MyLoginTheme
import androidx.compose.foundation.Image as Image

class MyTrips : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLoginTheme {
                Trips(ProductsRepository.getProductsList(), LocaisRepository.getLocaisList())


            }
        }
    }
}

@Composable

fun Trips(products: List<Products> , locais: List<Locais>) {
    //surface que vai segurar tudo
    Surface(modifier = Modifier.fillMaxSize()) {
        //Column que vai conter os conteudos
        Column(
            modifier = Modifier.fillMaxSize()

        ) {
            //surface para adm a imagem e as coisas que estao sobrepostas na imagem
            Surface(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.paisagem),
                    contentDescription = null
                )
                Column(
                    modifier = Modifier
                        .padding(15.dp)
                        .height(180.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    //Column pra imagem da mulher e nome
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment =
                        Alignment.End
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.image_mulher),
                            contentDescription = null, modifier = Modifier
                                .size(61.dp)
                                .border(
                                    BorderStroke(4.dp, color = Color.White),
                                    CircleShape
                                )
                                .padding(4.dp)
                                .clip(CircleShape)

                        )
                        Text(text = "Susanna Hoffs", color = Color.White)
                    }
                    //Column pro titulo
                    Column(

                    ) {
                        // Icon(painter = , contentDescription = )
                        Text(text = "You're in Paris", color = Color.White)
                        Text(text = "My Trips", color = Color.White)
                    }
                    //---------------------//
                }

            }
            Column(
                modifier = Modifier.padding(12.dp)

            ) {
                Text(text = "Categories", color = Color.Black)


                Spacer(modifier = Modifier.height(14.dp))

                Row(

                )
                {
                    LazyRow() {
                        items(products) { products ->

                            Card(
                                modifier = Modifier
                                    .width(109.dp)
                                    .height(64.dp)
                                    .padding(start = 8.dp),
                                backgroundColor = Color.Magenta,

                                ) {
                                Column(
                                    modifier = Modifier.padding(6.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center

                                ) {
                                    Image(
                                        painter = products.image
                                            ?: painterResource(id = R.drawable.montain),
                                        contentDescription = "",
                                        modifier = Modifier.size(32.dp)
                                    )
                                    Text(
                                        text = products.name,
                                        fontSize = 15.sp,
                                        color = Color.White
                                    )

                                }
                            }

                        }

                    }

                }
                //-----------Fazer o input e as outras list----------
                Spacer(modifier = Modifier.height(14.dp))

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 16.dp,
                            end = 17.dp
                        ),
                    shape = RoundedCornerShape(16.dp),
                    label = {
                        Text(text = "Search your destinity")
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(
                                id = R.drawable.baseline_search_24
                            ),
                            contentDescription = "",
                            tint = Color.Gray
                        )
                    }
                )
                Spacer(modifier = Modifier.height(14.dp))
                Text(text = "Past Trips", color = Color.Black)
                Spacer(modifier = Modifier.height(9.dp))

                LazyColumn(){
                    items(locais){ locais ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(208.dp),
                            elevation = 8.dp
                        ) {
                            Column(
                                modifier = Modifier
                                .padding(5.dp)
                                .fillMaxWidth(),
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                Image(
                                    painter = locais.image ?:
                                painterResource(
                                    id = R.drawable.baseline_person_24
                                ),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(106.dp)
                                        .clip(shape = RoundedCornerShape(10.dp)),
                                    contentScale = ContentScale.Crop
                                )
                                Text(
                                    text = locais.name,
                                    fontSize = 15.sp,
                                    color = Color.Blue
                                )

                                Text(
                                    text = locais.description,
                                    fontSize = 15.sp,
                                    color = Color.Blue
                                )
                                Text(
                                    text = locais.datas,
                                    fontSize = 15.sp,
                                    color = Color.Blue
                                )
                            }

                        }
                        Spacer(modifier = Modifier.height(11.dp))
                    }


                }


            }
        }


    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Trips(ProductsRepository.getProductsList(), LocaisRepository.getLocaisList())

}