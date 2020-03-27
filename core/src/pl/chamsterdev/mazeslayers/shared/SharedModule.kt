package pl.chamsterdev.mazeslayers.shared

import com.badlogic.gdx.assets.AssetManager
import dagger.Module
import dagger.Provides
import java.awt.Font
import javax.inject.Singleton

@Module
class SharedModule {

    @Singleton
    @Provides
    fun getDeviceService(): DeviceService = DeviceService()

    @Provides
    @Singleton
    fun getAssetManager(): AssetManager = AssetManager()

    @Singleton
    @Provides
    fun getGameService(): GameService = GameService()

    @Singleton
    @Provides
    fun getFontService(): FontService = FontService()

    @Singleton
    @Provides
    fun getAssetsHelper(): AssetsHelper = AssetsHelper()
}
