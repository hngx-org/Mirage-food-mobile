package com.shegs.miragefood.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shegs.miragefood.R
import com.shegs.miragefood.ui.theme.Poppins
import com.shegs.miragefood.ui.theme.md_theme_light_scrim


@Preview
@Composable
fun OnBoardingScreen_1() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(100.dp))

        Column(
            modifier = Modifier
                .height(545.dp)
                .width(343.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {

            //image
            Column(
                modifier = Modifier
                    .height(405.dp)
                    .width(320.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Column(
                    modifier = Modifier
                        .width(282.dp)
                        .height(237.dp), horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.onboarding_img1),
                        contentDescription = null,
                        modifier = Modifier
                            .height(237.dp)
                            .width(282.dp)
                    )
                }

                Spacer(modifier = Modifier.height(40.dp))
                //texts

                Column(
                    modifier = Modifier
                        .height(96.dp)
                        .width(320.dp), horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(36.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        //stringResource(id = R.string.onBoardHeader1).HeadingText()
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Column(
                        modifier = Modifier
                            .width(300.dp)
                            .height(52.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        //stringResource(id = R.string.onBoarding1Msg).NormalText()
                    }

                }

                Spacer(modifier = Modifier.height(20.dp))

                // ellipse swipe able  views.
                Column(
                    modifier = Modifier
                        .width(320.dp)
                        .height(128.dp), horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Column(
                        modifier = Modifier
                            .width(44.dp)
                            .height(13.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {

                            Column(
                                modifier = Modifier
                                    .width(13.dp)
                                    .height(13.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ellipse_on),
                                    contentDescription = null,
                                    contentScale = ContentScale.None
                                )

                            }

                            Column(
                                modifier = Modifier
                                    .width(13.dp)
                                    .height(13.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ellipse_off),
                                    contentDescription = null,
                                    contentScale = ContentScale.None
                                )

                            }

                            Column(
                                modifier = Modifier
                                    .width(13.dp)
                                    .height(13.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ellipse_off),
                                    contentDescription = null,
                                    contentScale = ContentScale.None
                                )

                            }


                        }

                    }
                }
            }


            Spacer(modifier = Modifier.height(30.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
            ) {
                Column {
                    FilledCornerButton(text = "Sign Up"  /*TODO*/) {
                    }

                }
                Column {
                    OutlinedButton(text = "Sign In" /*TODO*/) {

                    }
                }

            }


        }

    }
}


@Composable
fun FilledCornerButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick, modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White
        )
    ) {
        Text(text = text)
    }
}

@Composable
fun OutlinedButton(text: String, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick, modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(text = text, color = Color(0xFF967BB6))
    }
}

@Composable
fun String.NormalText() {
    Text(
        text = this,
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight(400),
            fontStyle = FontStyle.Normal,
            fontFamily = Poppins
        ),
        color = Color(0x991E1E1E),
        textAlign = TextAlign.Center
    )

}

@Composable
fun String.HeadingText() {
    Text(
        text = this,
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight(500),
            fontStyle = FontStyle.Normal,
            fontFamily = Poppins
        ),
        color = md_theme_light_scrim,
    )

}

