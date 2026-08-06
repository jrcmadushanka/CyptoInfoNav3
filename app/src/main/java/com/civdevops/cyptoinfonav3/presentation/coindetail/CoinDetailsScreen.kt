package com.civdevops.cyptoinfonav3.presentation.coindetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.civdevops.cyptoinfonav3.common.formatDate
import com.civdevops.cyptoinfonav3.presentation.coindetail.component.CoinDetailsHeader
import com.civdevops.cyptoinfonav3.presentation.coindetail.component.CoinDetailsInfoSection
import com.civdevops.cyptoinfonav3.presentation.coindetail.component.CoinDetailsSection
import com.civdevops.cyptoinfonav3.presentation.coindetail.component.CoinDetailsWhitePaper

@Composable
fun CoinDetailsScreen(
    coinDetailsViewModel: CoinDetailViewModel = hiltViewModel(),
    modifier: Modifier
) {
    val state by coinDetailsViewModel.state.collectAsStateWithLifecycle()

    val uriHandler = LocalUriHandler.current

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        state.data?.let {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                CoinDetailsHeader(
                    name = it.name,
                    title = it.title,
                    status = it.isActive,
                    logo = it.logo
                )

                LazyColumn(
                    Modifier.fillMaxHeight()
                ) {
                    item {
                        it.description?.let { description ->
                            CoinDetailsSection(
                                title = "Description",
                                detail = description
                            )
                        }

                        it.startedAt?.let { date ->
                            CoinDetailsSection(
                                title = "Started On",
                                detail = formatDate(date, "dd MMM yyyy, hh:mm a") ?: "-"
                            )
                        }

                        CoinDetailsInfoSection(
                            header = "Information",
                            infoList = it.infoList
                        )

                        it.tags?.let { tags ->
                            CoinDetailsInfoSection(
                                header = "Tags",
                                infoList = tags
                            )
                        }

                        it.whitepaper.link?.let { uri ->
                            CoinDetailsWhitePaper() {
                                 uriHandler.openUri(uri)
                            }
                        }
                    }
                }
            }
        }

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .width(32.dp)
                    .height(32.dp)
            )
        }

        state.error?.let {
            Text(
                text = it,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Red,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}