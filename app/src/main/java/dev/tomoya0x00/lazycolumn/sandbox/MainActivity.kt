package dev.tomoya0x00.lazycolumn.sandbox

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
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
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.util.rangeTo
import dev.tomoya0x00.lazycolumn.sandbox.ui.theme.ComposeLazyColumnSandboxTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLazyColumnSandboxTheme {
                // A surface container using the 'background' color from the theme
                val lazyListState = rememberLazyListState()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainContent(
                        data = dummy,
                        lazyListState = lazyListState,
                    )

                    LaunchedEffect(Unit) {
                        val itemsCount = lazyListState.layoutInfo.totalItemsCount
                        val range = 0..itemsCount step 20
                        val delay = 1000L
                        while(coroutineContext.isActive) {
                            for(i in range) {
                                delay(delay)
                                lazyListState.animateScrollToItem(i)
                            }
                            for(i in range.reversed()) {
                                delay(delay)
                                lazyListState.animateScrollToItem(i)
                            }
                        }
                    }
                }
            }
        }
    }
}

val dummy = (0..200).map { cnt ->
    DummyData(
        id = cnt,
        numbers = (0..40).toList()
    )
}
