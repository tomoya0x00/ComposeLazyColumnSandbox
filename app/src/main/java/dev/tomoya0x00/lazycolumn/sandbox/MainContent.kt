package dev.tomoya0x00.lazycolumn.sandbox

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable

/**
 * Created by tomoya0x00 on 2022/03/12.
 */
@Composable
fun MainContent(
    data: List<DummyData>
) {
    LazyColumn {
        items(
            items = data,
            key = { it.id }
        ) {
            MainRow(
                data = it,
            )
        }
    }
}