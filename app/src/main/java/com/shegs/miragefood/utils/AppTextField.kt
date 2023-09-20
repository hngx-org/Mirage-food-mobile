package com.shegs.miragefood.utils


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.shegs.miragefood.ui.theme.Typography
import com.shegs.miragefood.ui.theme.grey2
import com.shegs.miragefood.ui.theme.grey3
import com.shegs.miragefood.ui.theme.md_theme_light_onPrimary


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTextField(
    leadingIcon: Int? = 0,
    modifier: Modifier,
    value: String,
    placeholder: String,
    onValueChanged: (String?) -> Unit
) {
    OutlinedTextField(
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = grey2,
            unfocusedBorderColor = md_theme_light_onPrimary,
            focusedBorderColor = md_theme_light_onPrimary
        ),
        placeholder = {
            Text(
                text = placeholder,
                style = Typography.bodySmall.copy(
                    fontSize = 12.sp,
                    lineHeight = 18.sp,
                    fontWeight = FontWeight.W500,
                    color = grey3
                )
            )
        },
        shape = ShapeDefaults.Medium,
        modifier = modifier,
        leadingIcon = leadingIcon?.let {
            {
                Icon(
                    painter = painterResource(id = it),
                    tint = grey3,
                    contentDescription = "leading icon",
                )
            }

        },
        value = value,
        onValueChange = { newValue ->
            onValueChanged(newValue)
        },
    )
}

@Preview
@Composable
fun PreviewTextField() {
    AppTextField(
        value = "",
        placeholder = "Search co-worker",
        modifier = Modifier.padding()
    ) {

    }
}