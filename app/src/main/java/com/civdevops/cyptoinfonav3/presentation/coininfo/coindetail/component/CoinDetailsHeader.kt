package com.civdevops.cyptoinfonav3.presentation.coininfo.coindetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_NO
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.civdevops.cyptoinfonav3.R

@Composable
fun CoinDetailsHeader(
    name: String,
    title: String,
    status: Boolean,
    logo: String?,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(vertical = 6.dp, horizontal = 16.dp)
            .background(MaterialTheme.colorScheme.background),
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            logo?.let {
                AsyncImage(
                    modifier = Modifier
                        .width(36.dp)
                        .height(36.dp)
                        .weight(2f),
                    model = it,
                    contentDescription = "$name logo"
                )
            }

            Text(
                text = title,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.headlineSmall,
                maxLines = 1,
                modifier = Modifier.weight(12f)
            )

            Icon(
                if (status) {
                    painterResource(R.drawable.baseline_check_circle_24)
                } else {
                    painterResource(R.drawable.baseline_unpublished_24)
                },
                contentDescription = "Coin active icon",
                tint = if (status) {
                    Color.Green
                } else Color.Red,
                modifier = Modifier
                    .height(36.dp)
                    .width(36.dp)
                    .weight(2f)
            )
        }
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun PreviewCoinDetailHeader() {
    MaterialTheme() {
        CoinDetailsHeader(
            "Bitcoin",
            "1. Bitcoin (BTC)",
            true,
            "https://thumbs.dreamstime.com/b/bitcoin-orange-logo-icon-circle-cryptocurrency-btc-payment-symbol-flat-style-illustration-isolated-white-background-226221967.jpg"
        )
    }
}