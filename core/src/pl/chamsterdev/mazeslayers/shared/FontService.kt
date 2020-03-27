package pl.chamsterdev.mazeslayers.shared

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.scenes.scene2d.ui.Label
import pl.chamsterdev.mazeslayers.dagger.DI
import javax.inject.Inject

class FontService {

    @Inject
    lateinit var assetManager: AssetManager

    init {
        DI.shared.inject(this)
    }

    fun getFont(): BitmapFont {
        return assetManager.get(Asset.BASE_FONT.path)
    }

    fun createLabelStyleWithFont(scale: Float = 1f): Label.LabelStyle {
        val style = Label.LabelStyle()
        style.font = getFont()
        style.font.region.texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)
        style.font.data.setScale(scale)
        return style
    }
}
