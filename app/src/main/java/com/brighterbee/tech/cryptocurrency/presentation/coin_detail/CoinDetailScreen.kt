package com.brighterbee.tech.cryptocurrency.presentation.coin_detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.brighterbee.tech.cryptocurrency.presentation.coin_detail.components.CoinTag
import com.brighterbee.tech.cryptocurrency.presentation.coin_detail.components.TeamListItem
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailsViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()){

        state.coinDetails?.let { coinDetails ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ){
                item{
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ){
                        Text(
                            text = "${coinDetails.rank} . ${coinDetails.name} (${coinDetails.symbol})",
                            style = MaterialTheme.typography.h5,
                            modifier = Modifier.weight(8f),
                        )
                        Text(
                            text = if(coinDetails.isActive) "active" else "inactive",
                            color = if(coinDetails.isActive) Color.Green else Color.Red,
                            fontStyle = FontStyle.Italic,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .align(CenterVertically)
                                .weight(2f),
                        )
                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = coinDetails.description,
                        style = MaterialTheme.typography.body2,
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = "Tags",
                        style = MaterialTheme.typography.h5,
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    FlowRow(
                        mainAxisSpacing = 10.dp,
                        crossAxisSpacing = 10.dp,
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        coinDetails.tags.forEach { tag -> CoinTag(tag) }
                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = "Team members",
                        style = MaterialTheme.typography.h5,
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                }

                items(coinDetails.team){ team ->
                    TeamListItem(
                        team,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                    )
                    Divider()
                }

            }
        }

        if(state.error.isNotBlank()){
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center),
            )
        }

        if(state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

    }
}
