package dev.tomoya0x00.lazycolumn.sandbox

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Created by tomoya0x00 on 2022/03/12.
 */
@Composable
fun MainItem(
    url: String,
) {
    Box(
        modifier = rootModifier,
    ) {

    }
}

private val rootModifier by lazy {
    Modifier
        .padding(start = 8.dp)
        .size(
            width = 160.dp,
            height = 90.dp
        ).background(
            color = Color.Gray,
            shape = RoundedCornerShape(size = 8.dp),
        )
}