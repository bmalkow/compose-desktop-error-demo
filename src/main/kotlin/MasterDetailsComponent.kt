import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.replaceCurrent
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize

class MasterDetailsComponent(componentContext: ComponentContext) : MasterDetails, ComponentContext by componentContext {

	private val router = router<Configuration, MasterDetails.Child>(
		key = "AccountsSettings",
		initialConfiguration = Configuration.WelcomeScreen,
		handleBackButton = true,
		childFactory = ::createChild
	)

	override val routerState: Value<RouterState<Configuration, MasterDetails.Child>> = router.state

	private fun createChild(configuration: Configuration, componentContext: ComponentContext): MasterDetails.Child =
		when (configuration) {
			is Configuration.Details -> MasterDetails.Child.DetailScreen(configuration.id)
			Configuration.WelcomeScreen -> MasterDetails.Child.WelcomeScreen
		}

	override fun selectMenuItem(id: Int) {
		if (id == 0) router.replaceCurrent(Configuration.WelcomeScreen) else router.replaceCurrent(
			Configuration.Details(
				id
			)
		)
	}

	sealed class Configuration : Parcelable {

		@Parcelize
		object WelcomeScreen : Configuration()

		@Parcelize
		data class Details(val id: Int) : Configuration()
	}

}