package com.civdevops.cyptoinfonav3.presentation.coinlist.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.civdevops.cyptoinfonav3.domain.model.Coin

@Composable
fun CoinListItem(coin: Coin) {
    Box(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${coin.rank}. ${coin.name}(${coin.symbol})",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                text = if (coin.isActive) "Active" else "Inactive",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = if (coin.isActive) Color.Green else MaterialTheme.colorScheme.error,
            )
        }
    }
}

@Composable
@Preview
fun PreviewCoinListItem(){
    MaterialTheme(){
        CoinListItem(Coin("1",
            isActive = true,
            isNew = true,
            name = "Bitcoin",
            symbol = "BTC",
            rank = 1
        ))
    }
}