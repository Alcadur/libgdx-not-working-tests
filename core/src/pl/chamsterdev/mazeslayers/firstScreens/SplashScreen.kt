package pl.chamsterdev.mazeslayers.firstScreens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import pl.chamsterdev.mazeslayers.screens.BaseScreen
import pl.chamsterdev.mazeslayers.shared.Asset

class SplashScreen : BaseScreen() {
    lateinit var batch: SpriteBatch
    var img: Texture? = null

    init {
        this.inject()
    }

    override fun show() {
        batch = gameService.batch
        img = assetsHelper.getTextureFromAsset(Asset.LOGO)
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
