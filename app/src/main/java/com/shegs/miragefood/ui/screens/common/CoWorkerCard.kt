package com.shegs.miragefood.ui.screens.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shegs.miragefood.R
import com.shegs.miragefood.models.datas.CoWorker

@Composable
fun CoWorkerCard(
    coWorker: CoWorker,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(MaterialTheme.shapes.medium)
                .background(Color.Transparent, MaterialTheme.shapes.medium),
        ) {
            Image(
                painter = painterResource(id = coWorker.profilePicture),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        Column(
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = coWorker.name,
                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                color = MaterialTheme.colorScheme.scrim.copy(0.6f)
            )
            Text(
                text = coWorker.department,
                fontFamily = FontFamily(Font(R.font.poppins_light)),
                color = MaterialTheme.colorScheme.scrim.copy(0.6f)
            )
        }
    }
}

@Preview
@Composable
fun CoWorkerCardPreview() {
    CoWorkerCard(
        coWorker = CoWorker(
            name = "Chinaza",
            department = "Engineering",
            profilePicture = R.drawable.user_image
        ),
        onClick = {}
    )
}