package pl.chamsterdev.mazeslayers.shared

import dagger.Module
import dagger.Provides

@Module
class SharedModule {

    @Provides
    fun getDeviceService(): DeviceService = DeviceService()
}
