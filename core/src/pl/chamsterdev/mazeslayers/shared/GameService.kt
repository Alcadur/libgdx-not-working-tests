package pl.chamsterdev.mazeslayers.shared

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import pl.chamsterdev.mazeslayers.MazeSlayers
import javax.inject.Inject

class GameService @Inject constructor() {
    private var gameInstance: MazeSlayers? = null
    val batch: SpriteBatch = SpriteBatch()
    var game: MazeSlayers
        get() = gameInstance!!
        set(game) {
            if(gameInstance == null) {
                gameInstance = game
            }
        }


}
