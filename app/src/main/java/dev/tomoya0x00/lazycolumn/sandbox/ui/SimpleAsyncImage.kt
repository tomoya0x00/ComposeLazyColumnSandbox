package dev.tomoya0x00.lazycolumn.sandbox.ui

import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

@Composable
fun SimpleAsyncImage(
    modifier: Modifier = Modifier,
    url: String?,
    contentDescription: String?,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
) {
    val imageBitmapState: MutableState<ImageBitmap?> = remember { mutableStateOf(null) }
    val painter: Painter? =
        remember(imageBitmapState.value) { imageBitmapState.value?.let { BitmapPainter(it) } }

    // If in preview mode, don't use glide
    if (!LocalInspectionMode.current) {
        val context = LocalContext.current
        DisposableEffect(url) {
            val target = createTarget(imageBitmapState)
            val glide = Glide.with(context)
            glide.load(url).dontAnimate().into(target)

            onDispose { glide.clear(target) }
        }
    } else {
        DummyContentForPreview()
    }

    painter?.let {
        Image(
            modifier = modifier,
            painter = it,
            contentDescription = contentDescription,
            alignment = alignment,
            contentScale = contentScale,
            alpha = alpha,
            colorFilter = colorFilter,
        )
    }
}

private fun createTarget(
    imageBitmapState: MutableState<ImageBitmap?>,
) = object : CustomTarget<Drawable>() {
        override fun onResourceReady(
            resource: Drawable,
            transition: Transition<in Drawable>?,
        ) = updateRememberedDrawable(resource)

        override fun onLoadFailed(
            errorDrawable: Drawable?,
        ) = updateRememberedDrawable(errorDrawable)

        override fun onLoadCleared(
            placeholder: Drawable?,
        ) = updateRememberedDrawable(placeholder)

        private fun updateRememberedDrawable(
            drawable: Drawable?,
        ) {
            imageBitmapState.value =
                when (drawable) {
                    is BitmapDrawable -> drawable.bitmap.asImageBitmap()
                    else -> null
                }
        }
    }

@Composable
private fun DummyContentForPreview() {
    Box(
        modifier = Modifier.fillMaxSize().background(Color.Black),
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "SimpleAsyncImage",
            color = Color.White,
        )
    }
}
