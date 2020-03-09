package pl.chamsterdev.mazeslayers.dagger

import pl.chamsterdev.mazeslayers.shared.DaggerSharedComponent
import pl.chamsterdev.mazeslayers.shared.SharedComponent

object DI {
    val shared: SharedComponent = DaggerSharedComponent.create()
}
