package pl.chamsterdev.mazeslayers.shared

import dagger.Component
import pl.chamsterdev.mazeslayers.MazeSlayers
import javax.inject.Singleton

@Singleton
@Component(modules = [SharedModule::class])
interface SharedComponent {
    fun inject(app: MazeSlayers)
}