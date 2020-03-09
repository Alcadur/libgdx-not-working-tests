package pl.chamsterdev.mazeslayers.shared

import com.badlogic.gdx.graphics.Texture
import javax.inject.Inject

class AssetsService @Inject constructor() {
    private val texturesMap: HashMap<String, Texture> = HashMap()

    fun load(asset: Asset): Texture {
        texturesMap[asset.path] = Texture(asset.path)
        return texturesMap[asset.path]!!
    }

    fun loadChain(asset: Asset): AssetsService {
        texturesMap[asset.path] = Texture(asset.path)
        return this
    }

    fun getTexture(asset: Asset): Texture? {
        return texturesMap[asset.path]
    }
}
