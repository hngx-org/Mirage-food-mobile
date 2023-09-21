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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shegs.miragefood.R

@Preview
@Composable
fun OnBoardingScreen_3() {
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
                        painter = painterResource(id = R.drawable.onboarding_img_3),
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

                        stringResource(id = R.string.onBoardHeader3).HeadingText()
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        stringResource(id = R.string.onBoarding3Msg).NormalText()
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