package pl.chamsterdev.mazeslayers.shared

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.scenes.scene2d.ui.Image
import pl.chamsterdev.mazeslayers.dagger.DI
import javax.inject.Inject

class AssetsHelper {

    @Inject
    lateinit var assetManager: AssetManager

    init {
        DI.shared.inject(this)
    }

    fun loadAllAssets() {
        Asset.getValuesAsSet().forEach {
            assetManager.load(it.path, it.clazz)
        }

        assetManager.finishLoading()
    }

    fun getTextureFromAsset(asset: Asset): Texture {
        return assetManager.get(asset.path, Texture::class.java)
    }

    fun getImageFromAsset(asset: Asset): Image {
        return Image(getTextureFromAsset(asset))
    }
}


