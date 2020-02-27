package pl.chamsterdev.mazeslayers

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import pl.chamsterdev.mazeslayers.shared.DaggerSharedComponent
import pl.chamsterdev.mazeslayers.shared.DeviceService
import javax.inject.Inject

class MazeSlayers : ApplicationAdapter() {
    var batch: SpriteBatch? = null
    var img: Texture? = null

    @Inject
    lateinit var deviceService: DeviceService

    override fun create() {
        DaggerSharedComponent.create().inject(this)
        batch = SpriteBatch()
        img = Texture("maze-slayers-splash-screen.png")
    }

    override fun render() {
        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        batch!!.begin()
        batch!!.draw(img, 0f, 0f, deviceService.deviceWidthF, deviceService.deviceHeightF)
        batch!!.end()
    }

    override fun dispose() {
        batch!!.dispose()
        img!!.dispose()
    }
}
