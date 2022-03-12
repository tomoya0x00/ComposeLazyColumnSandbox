package dev.tomoya0x00.lazycolumn.sandbox

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
                modifier = Modifier.padding(top = 8.dp),
            )
        }
    }
}