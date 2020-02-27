package pl.chamsterdev.mazeslayers.shared

import com.badlogic.gdx.Gdx
import javax.inject.Singleton

@Singleton
class DeviceService {
    val deviceWidth = Gdx.graphics.width
    val deviceWidthF = deviceWidth.toFloat()
    val deviceHeight = Gdx.graphics.height
    val deviceHeightF = deviceHeight.toFloat()
}
