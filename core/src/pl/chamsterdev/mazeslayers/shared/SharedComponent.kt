package pl.chamsterdev.mazeslayers.shared

import dagger.Component
import pl.chamsterdev.mazeslayers.MazeSlayers
import pl.chamsterdev.mazeslayers.screens.BaseScreen
import pl.chamsterdev.mazeslayers.screens.mainScreen.MenuSelector
import javax.inject.Singleton

@Singleton
@Component(modules = [SharedModule::class])
interface SharedComponent {
    fun inject(app: MazeSlayers)
    fun inject(screen: BaseScreen)
    fun inject(menuSelector: MenuSelector)
    fun inject(fontService: FontService)
    fun inject(assetsHelper: AssetsHelper)
}
