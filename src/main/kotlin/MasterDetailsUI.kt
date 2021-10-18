import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.Children

@Composable
fun RootContent(component: MasterDetails) {

	Row(verticalAlignment = Alignment.Top, modifier = Modifier.background(MaterialTheme.colors.surface)) {

		Column {
			MenuItem(0, "Welcome", component::selectMenuItem)
			MenuItem(1, "Details 1", component::selectMenuItem)
			MenuItem(2, "Details 2", component::selectMenuItem)
			MenuItem(3, "Details 3", component::selectMenuItem)
		}

		Column(modifier = Modifier.padding(start = 50.dp)) {
			Children(routerState = component.routerState) {
				when (val i = it.instance) {
					is MasterDetails.Child.DetailScreen -> Details(i.id)
					MasterDetails.Child.WelcomeScreen -> Text("""
						Test scenario:
						1. Click `Details 1` and click on text field
						2. Click Welcome
						3. Click `Details 2` and click on text field
						4. Click `Details 3` and click on text field (crash!)
					""".trimIndent())
				}
			}
		}

	}

}

@Composable
fun MenuItem(id: Int, text: String, onCLick: (Int) -> Unit) {
	Row(modifier = Modifier.padding(10.dp).clickable { onCLick(id) }) {
		Text(text)
	}
}

@Composable
fun Details(id: Int) {
	val text = remember { mutableStateOf("Text $id") }
	OutlinedTextField(
		text.value,
		textStyle = TextStyle.Default.copy(color = MaterialTheme.colors.onBackground),
		onValueChange = { text.value= it },
		modifier = Modifier.background(Color.Transparent).padding(12.dp)
		//	.onPreviewKeyEvent(onKeyUp(Key.Enter, component::onSendClick)).weight(1f).focusRequester(focusRequester)
	)
}
