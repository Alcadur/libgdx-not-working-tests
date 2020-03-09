package pl.chamsterdev.mazeslayers.firstScreens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import pl.chamsterdev.mazeslayers.dagger.DI
import pl.chamsterdev.mazeslayers.shared.Asset
import pl.chamsterdev.mazeslayers.shared.AssetsService
import pl.chamsterdev.mazeslayers.shared.DeviceService
import pl.chamsterdev.mazeslayers.shared.GameService
import javax.inject.Inject

class SplashScreen : ScreenAdapter() {
    lateinit var batch: SpriteBatch
    var img: Texture? = null

    @Inject
    lateinit var deviceService: DeviceService

    @Inject
    lateinit var assetsService: AssetsService

    @Inject
    lateinit var gameService: GameService

    override fun show() {
        DI.shared.inject(this)
        batch = gameService.batch
        img = assetsService.getTexture(Asset.LOGO)
    }

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        batch.begin()
        batch.draw(img, 0f, 0f, deviceService.deviceWidthF, deviceService.deviceHeightF)
        batch.end()
    }

    override fun dispose() {
        batch.dispose()
        img!!.dispose()
    }
}
