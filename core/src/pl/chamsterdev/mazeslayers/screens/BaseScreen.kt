package pl.chamsterdev.mazeslayers.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.GL20
import pl.chamsterdev.mazeslayers.dagger.DI
import pl.chamsterdev.mazeslayers.shared.AssetsService
import pl.chamsterdev.mazeslayers.shared.DeviceService
import pl.chamsterdev.mazeslayers.shared.GameService
import javax.inject.Inject

abstract class BaseScreen () : ScreenAdapter() {
    @Inject
    lateinit var deviceService: DeviceService

    @Inject
    lateinit var assetsService: AssetsService

    @Inject
    lateinit var gameService: GameService

    fun inject() {
        DI.shared.inject(this)
    }

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 0f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    }

    // TODO: remove before release
    // For debug
    fun log(tag: String, message: String) {
        Gdx.app.log(tag, message)
    }
}
