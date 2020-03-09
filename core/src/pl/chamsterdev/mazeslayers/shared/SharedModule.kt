package pl.chamsterdev.mazeslayers.shared

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SharedModule {

    @Singleton
    @Provides
    fun getDeviceService(): DeviceService = DeviceService()

    @Provides
    @Singleton
    fun getAssetsService(): AssetsService = AssetsService()

    @Singleton
    @Provides
    fun getGameService(): GameService = GameService()
}
