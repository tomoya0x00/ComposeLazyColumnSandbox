package dev.tomoya0x00.lazycolumn.sandbox

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Created by tomoya0x00 on 2022/03/12.
 */
@Composable
fun MainRow(
    data: DummyData,
) {
    Column(modifier = rootModifier) {
        Text(
            text = data.id.toString(),
            modifier = textModifier
        )

        LazyRow {
            items(
                items = data.urls,
                key = { it }
            ) { url ->
                MainItem(
                    url = url,
                )
            }
        }
    }
}

private val rootModifier by lazy {
    Modifier.padding(top = 8.dp)
}

private val textModifier by lazy {
    Modifier.padding(start = 8.dp)
}