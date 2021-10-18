// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.lifecycle.LifecycleController
import com.arkivanov.essenty.lifecycle.LifecycleRegistry

@ExperimentalDecomposeApi
fun main() = application {
	val lifecycle = LifecycleRegistry()
	val windowState = rememberWindowState()
	LifecycleController(lifecycle, windowState)

	val root = MasterDetailsComponent(DefaultComponentContext(lifecycle = lifecycle))

	Window(onCloseRequest = ::exitApplication) {
		RootContent(root)
	}
}
