package pl.chamsterdev.mazeslayers.shared

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.utils.Disposable
import javax.inject.Inject

class AssetsService @Inject constructor() {
    private val texturesMap: HashMap<String, Texture> = HashMap()

    fun load(asset: Asset): AssetsService {
        texturesMap[asset.path] = Texture(asset.path)
        return this
    }

    fun getTexture(asset: Asset): Texture? {
        return texturesMap[asset.path]
    }

    fun disposeAll() {
        texturesMap.forEach { (key, texture) ->
            texture.dispose()
        }
    }

    fun disposeAll(assets: Iterable<Disposable>) {
        assets.forEach { it.dispose() }
    }

    fun loadAllAssets() {
        Asset.getValuesAsSet().forEach {
            load(it)
        }
    }
}
