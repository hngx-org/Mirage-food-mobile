package com.shegs.miragefood.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shegs.miragefood.R


@Preview
@Composable
fun Notification_Screen() {

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(16.dp)
        .background(Color.White),horizontalAlignment = Alignment.CenterHorizontally) {

        Column (modifier = Modifier
            .border(width = 0.3.dp, color = Color(0x801E1E1E))
            .fillMaxWidth()
            .height(47.dp)
            .padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 10.dp)
        ){
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .height(27.dp),horizontalAlignment = Alignment.CenterHorizontally) {
                    "Notification".NotifHeaderTxtStyle()

                }
            }
        }


        Spacer(modifier = Modifier.height(36.dp))

        Column(modifier = Modifier
            .width(310.dp)
            .height(299.dp)

        ) {

            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start,
            ) {


                Column(modifier = Modifier
                    .width(82.dp)
                    .height(21.dp)) {
                    "Jul 24, 2023".LittleText() // change to put extra to input real date from transaction
                }


                Column(modifier = Modifier
                    .width(300.dp)
                    .height(119.dp)
                    .padding(top = 12.dp, bottom = 12.dp)) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
                        verticalAlignment = Alignment.Top,
                    ) {



                        Column(modifier = Modifier
                            .width(36.dp)
                            .height(36.dp)
                            .background(
                                color = Color(0x1A967BB6),
                                shape = RoundedCornerShape(size = 8.dp)
                            ), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

                            Column(modifier = Modifier
                                .padding(1.dp)
                                .width(20.dp)
                                .height(20.dp)) {
                                Image(
                                    painter = painterResource(id = R.drawable.notif_bell),
                                    contentDescription = null,
                                    contentScale = ContentScale.None, alignment = Alignment.Center
                                )
                            }

                        }

                        // sending lunch txt
                        Column(modifier = Modifier
                            .width(248.dp)
                            .height(95.dp)) {

                            Column {
                                "You’re a good sport ! 😊".NotifHeaderTxtStyle()
                            }
                            Column{
                                "Esther Dapo".FreeLunchSentTxt()
                            }

                            Column{
                                "3 : 34pm".LittleText()
                            }
                        }


                    }

                }



                Column(modifier = Modifier
                    .width(300.dp)
                    .height(119.dp)
                    .padding(top = 12.dp, bottom = 12.dp)) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
                        verticalAlignment = Alignment.Top,
                    ) {


                        Column(modifier = Modifier
                            .width(36.dp)
                            .height(36.dp)
                            .background(
                                color = Color(0x1A967BB6),
                                shape = RoundedCornerShape(size = 8.dp)
                            ), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

                            Column(modifier = Modifier
                                .padding(1.dp)
                                .width(20.dp)
                                .height(20.dp)) {
                                Image(
                                    painter = painterResource(id = R.drawable.notif_bell),
                                    contentDescription = null,
                                    contentScale = ContentScale.None, alignment = Alignment.Center
                                )
                            }

                        }



                        Column(modifier = Modifier
                            .width(248.dp)
                            .height(95.dp)) {

                            Column {
                                "Yay ! You’ve got something 😋".NotifHeaderTxtStyle()
                            }
                            Column{
                                FreeLunchRecievedTxt(amount = 2, senderName = "Fola")
                            }
                            Column{
                                Text(text = "‘You sabi work die !’",
                                    fontSize = 14.sp, fontFamily = FontFamily.SansSerif,
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF1E1E1E),

                                    )
                            }

                            Column{
                                "3 : 34pm".LittleText()
                            }
                        }



                    }

                }


            }

        }

        Spacer(modifier = Modifier.height(32.dp))

        Column(modifier = Modifier
            .width(310.dp)
            .height(299.dp)

        ) {

            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start,
            ) {


                Column(modifier = Modifier
                    .width(82.dp)
                    .height(21.dp)) {
                    "Jul 14, 2023".LittleText()
                }


                Column(modifier = Modifier
                    .width(300.dp)
                    .height(119.dp)
                    .padding(top = 12.dp, bottom = 12.dp)) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
                        verticalAlignment = Alignment.Top,
                    ) {

                        Column(modifier = Modifier
                            .width(36.dp)
                            .height(36.dp)
                            .background(
                                color = Color(0x1A967BB6),
                                shape = RoundedCornerShape(size = 8.dp)
                            ), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

                            Column(modifier = Modifier
                                .padding(1.dp)
                                .width(20.dp)
                                .height(20.dp)) {
                                Image(
                                    painter = painterResource(id = R.drawable.notif_bell),
                                    contentDescription = null,
                                    contentScale = ContentScale.None, alignment = Alignment.Center
                                )
                            }

                        }



                        Column(modifier = Modifier
                            .width(248.dp)
                            .height(95.dp)) {

                            Column {
                                "Withdrawal Sucessful".NotifHeaderTxtStyle()
                            }
                            Column{
                                WithdrawalTxt(amount = 2000)
                            }
                            Column{
                                "3 : 34pm".LittleText()
                            }
                        }


                    }

                }



                Column(modifier = Modifier
                    .width(300.dp)
                    .height(119.dp)
                    .padding(top = 12.dp, bottom = 12.dp)) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
                        verticalAlignment = Alignment.Top,
                    ) {

                        Column(modifier = Modifier
                            .width(36.dp)
                            .height(36.dp)
                            .background(
                                color = Color(0x1A967BB6),
                                shape = RoundedCornerShape(size = 8.dp)
                            ), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

                            Column(modifier = Modifier
                                .padding(1.dp)
                                .width(20.dp)
                                .height(20.dp)) {

                                Image(
                                    painter = painterResource(id = R.drawable.notif_bell),
                                    contentDescription = null,
                                    contentScale = ContentScale.None, alignment = Alignment.Center
                                )
                            }

                        }



                        Column(modifier = Modifier
                            .width(248.dp)
                            .height(95.dp)) {

                            Column {
                                "Yay ! You’ve got something 😋".NotifHeaderTxtStyle()
                            }
                            Column{
                                FreeLunchRecievedTxt(amount = 2, senderName = "Fola")
                            }
                            Column{
                                Text(text = "‘You sabi work die !’",
                                    fontSize = 14.sp, fontFamily = FontFamily.SansSerif,
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF1E1E1E),

                                    )
                            }

                            Column{
                                "3 : 34pm".LittleText()
                            }
                        }



                    }

                }


            }

        }



        //Add bottom nav








    }

}



@Composable
fun WithdrawalTxt(amount: Int){
    Text(text = "Your withdrawal of ₦$amount was successful",
        style = TextStyle(
            fontSize = 15.sp,
            fontFamily = FontFamily.SansSerif, //poppings
            fontWeight = FontWeight(500),
            color = Color(0x99646363)

        )
    )
}

@Composable
fun FreeLunchRecievedTxt(amount:Int, senderName:String){
    Text(
        text = "Your received $amount Free Lunch from $senderName",
        style = TextStyle(
            fontSize = 15.sp,
            fontFamily = FontFamily.SansSerif, //poppings
            fontWeight = FontWeight(500),
            color = Color(0x99646363)

        )
    )

}


@Composable
fun String.FreeLunchSentTxt(){
    Text(
        text = "Your Free Lunch gift to $this was successful",
        style = TextStyle(
            fontSize = 16.sp,
            fontFamily = FontFamily.SansSerif, //poppings
            fontWeight = FontWeight(500),
            color = Color(0x991E1E1E)

        )
    )

}


@Composable
fun String.NotifHeaderTxtStyle(){
    Text(
        text = this,
        style = TextStyle(
            fontSize = 18.sp,
            fontFamily = FontFamily.SansSerif, // change to poppings
            fontWeight = FontWeight(500),
            color = Color(0xFF1E1E1E),
        )
    )
}

@Composable
fun String.LittleText(){
    Text(
        text = this,
        style = TextStyle(
            fontSize = 14.sp,
            fontFamily = FontFamily.SansSerif, //poppings
            fontWeight = FontWeight(500),
            color = Color(0x991E1E1E),
        )
    )

}