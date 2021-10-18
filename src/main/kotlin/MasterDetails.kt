import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value

interface MasterDetails {

	val routerState: Value<RouterState<*, Child>>

	fun selectMenuItem(id: Int)

	sealed class Child {

		object WelcomeScreen : Child()
		data class DetailScreen(val id: Int) : Child()
	}
}