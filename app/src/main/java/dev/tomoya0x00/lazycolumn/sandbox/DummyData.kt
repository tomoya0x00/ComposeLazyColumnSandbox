package dev.tomoya0x00.lazycolumn.sandbox

import androidx.compose.runtime.Immutable

/**
 * Created by tomoya0x00 on 2022/03/12.
 */
@Immutable
data class DummyData(
    val columnId: Int,
    val rowIds: List<String>,
)

const val dummyImageUrl = "https://via.placeholder.com/160x90.png"