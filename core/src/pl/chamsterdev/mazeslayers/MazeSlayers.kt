package pl.chamsterdev.mazeslayers

import com.badlogic.gdx.Game
import com.badlogic.gdx.assets.AssetManager
import pl.chamsterdev.mazeslayers.dagger.DI
import pl.chamsterdev.mazeslayers.screens.mainScreen.MainScreen
import pl.chamsterdev.mazeslayers.shared.AssetsHelper
import pl.chamsterdev.mazeslayers.shared.GameService
import javax.inject.Inject

class MazeSlayers : Game() {
    @Inject
    lateinit var gameService: GameService

    @Inject
    lateinit var assetManager: AssetManager

    @Inject
    lateinit var assetsHelper: AssetsHelper

    override fun create() {
        DI.shared.inject(this)
        gameService.game = this
        assetsHelper.loadAllAssets()

        this.setScreen(MainScreen())
    }

//    override fun render() {
//        super.render()
//    }

    override fun dispose() {
        assetManager.dispose()
    }
}
