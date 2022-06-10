package dev.tomoya0x00.lazycolumn.sandbox.ui

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * ModifierCacheHolder
 *
 * Especially with LazyList, performance is degraded because Modifiers are instantiated on every
 * scroll. That's why we introduce ModifierCacheHolder.
 */
class ModifierCacheHolder {
    private val map = mutableMapOf<String, Modifier>()

    @SuppressLint("ModifierFactoryExtensionFunction", "ComposableModifierFactory")
    @Composable
    fun getOrCreate(
        tag: String,
        creator: @Composable () -> Modifier,
    ): Modifier = map[tag] ?: creator.invoke().also { map[tag] = it }
}
