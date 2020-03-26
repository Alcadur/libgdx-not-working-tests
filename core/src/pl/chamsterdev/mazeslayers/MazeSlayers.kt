package pl.chamsterdev.mazeslayers

import com.badlogic.gdx.Game
import pl.chamsterdev.mazeslayers.dagger.DI
import pl.chamsterdev.mazeslayers.screens.mainScreen.MainScreen
import pl.chamsterdev.mazeslayers.shared.AssetsService
import pl.chamsterdev.mazeslayers.shared.GameService
import javax.inject.Inject

class MazeSlayers : Game() {
    @Inject
    lateinit var assetsService: AssetsService

    @Inject
    lateinit var gameService: GameService

    override fun create() {
        DI.shared.inject(this)
        gameService.game = this
        assetsService.loadAllAssets()
//        this.setScreen(SplashScreen())
        this.setScreen(MainScreen())
    }

//    override fun render() {
//        super.render()
//    }

    override fun dispose() {
        assetsService.disposeAll()
    }
}
