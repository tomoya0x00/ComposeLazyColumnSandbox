package dev.tomoya0x00.lazycolumn.sandbox

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

/**
 * Created by tomoya0x00 on 2022/03/12.
 */
@Composable
fun MainRow(
    data: DummyData,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text(
            text = data.id.toString(),
            modifier = textModifier
        )

        // Since the scroll performance with Compose on low spec devices is too slow,
        // add delay to be able to skip drawing during scroll
        var showContent by remember { mutableStateOf(false) }

        if (showContent) {
            LazyRow {
                itemsIndexed(
                    items = data.numbers,
                    key = { index, _ -> index }
                ) { _, number ->
                    MainItem(
                        icon = icons[number % icons.size],
                        modifier = itemModifier
                    )
                }
            }
        } else {
            Spacer(modifier = itemModifier)
        }

        LaunchedEffect(Unit) {
            delay(10)
            showContent = true
        }
    }
}

private val textModifier = Modifier.padding(start = 8.dp)
private val itemModifier = Modifier
    .size(96.dp)
    .padding(horizontal = 32.dp)

private val icons by lazy {
    listOf(
        Icons.Default.LocationOn,
        Icons.Default.AccountBox,
        Icons.Default.Check,
        Icons.Default.AccountCircle,
        Icons.Default.Build,
        Icons.Default.Call,
        Icons.Default.DateRange,
        Icons.Default.Edit,
        Icons.Default.Delete,
        Icons.Default.List,
        Icons.Default.Face,
        Icons.Default.Notifications,
        Icons.Default.AddCircle,
        Icons.Default.Info,
        Icons.Default.Email,
        Icons.Default.Build,
        Icons.Default.KeyboardArrowDown,
        Icons.Default.KeyboardArrowUp,
        Icons.Default.Refresh,
        Icons.Default.MailOutline,
    )
}
