package dev.tomoya0x00.lazycolumn.sandbox

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Created by tomoya0x00 on 2022/03/12.
 */
@Composable
fun MainItem(
    icon: ImageVector,
    modifier: Modifier = Modifier,
) {
    Image(
        icon,
        modifier = modifier,
        contentDescription = null,
    )
}
