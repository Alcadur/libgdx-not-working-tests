package pl.chamsterdev.mazeslayers.shared

import com.badlogic.gdx.Gdx
import javax.inject.Inject

class DeviceService @Inject constructor( ) {
    val deviceWidth = Gdx.graphics.width
    val deviceWidthF = deviceWidth.toFloat()
    val deviceHeight = Gdx.graphics.height
    val deviceHeightF = deviceHeight.toFloat()
}
