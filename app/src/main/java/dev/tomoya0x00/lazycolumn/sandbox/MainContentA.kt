package dev.tomoya0x00.lazycolumn.sandbox

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

/**
 * Created by tomoya0x00 on 2022/03/12.
 */
@Composable
fun MainContentA(
    data: List<DummyData>
) {
    LazyColumn {
        items(
            items = data,
            key = { it.columnId },
        ) {
            MainRowA(
                data = it,
            )
        }
    }
}

@Composable
private fun MainRowA(
    data: DummyData,
) {
    Column(modifier = Modifier.padding(top = 8.dp)) {
        Text(
            text = data.columnId.toString(),
            modifier = Modifier.padding(start = 8.dp),
        )

        LazyRow {
            items(
                items = data.rowIds,
                key = { it },
            ) { rowId ->
                MainItemA(
                    text = "${data.columnId}_$rowId",
                )
            }
        }
    }
}

@Composable
private fun MainItemA(
    text: String,
) {
    Card(
        modifier = Modifier
            .padding(start = 8.dp)
            .width(120.dp)
            .aspectRatio(16f / 9),
    ) {
        Box {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = dummyImageUrl,
                contentDescription = null,
            )

            Text(text = text, modifier = Modifier.align(Alignment.TopCenter))
        }
    }
}
