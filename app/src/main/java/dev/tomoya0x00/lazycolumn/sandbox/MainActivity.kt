package dev.tomoya0x00.lazycolumn.sandbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import dev.tomoya0x00.lazycolumn.sandbox.ui.theme.ComposeLazyColumnSandboxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLazyColumnSandboxTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainContentB(data = dummy)
                }
            }
        }
    }
}

val dummy = (0..100).map { cnt ->
    DummyData(
        columnId = cnt,
        rowIds = (0..10).map { "$it" }
    )
}
