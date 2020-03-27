package pl.chamsterdev.mazeslayers.shared

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont

enum class Asset (val path: String, val clazz: Class<*>){
    // Textures
    LOGO("maze-slayers-splash-screen.png", Texture::class.java),
    LEFT_ARROW("main-screen/menu-arrow-left.png", Texture::class.java),
    RIGHT_ARROW("main-screen/menu-arrow-right.png", Texture::class.java),
    GAME_TOWER("main-screen/game-tower.png", Texture::class.java),
    GAME_MANSIONS("main-screen/game-mansions.png", Texture::class.java),
    GAME_ESCAPE("main-screen/game-escape.png", Texture::class.java),
    CHARACTER_ICON_MAG("main-screen/character-icon-mag.png", Texture::class.java),
    CHARACTER_ICON_PALADIN("main-screen/character-icon-paladin.png", Texture::class.java),
    CHARACTER_ICON_THIEF("main-screen/character-icon-thief.png", Texture::class.java),
    CHARACTER_ICON_VAMPIRE("main-screen/character-icon-vampire.png", Texture::class.java),
    MAZE_TYPE_SQUARE("main-screen/maze-type-square.png", Texture::class.java),

    // Fonts
    BASE_FONT("font.fnt", BitmapFont::class.java)
    ;

    companion object {
        fun getValuesAsSet(): Set<Asset> {
            return setOf(
                    LOGO,
                    LEFT_ARROW,
                    RIGHT_ARROW,
                    GAME_TOWER,
                    GAME_MANSIONS,
                    GAME_ESCAPE,
                    CHARACTER_ICON_MAG,
                    CHARACTER_ICON_PALADIN,
                    CHARACTER_ICON_THIEF,
                    CHARACTER_ICON_VAMPIRE,
                    BASE_FONT,
                    MAZE_TYPE_SQUARE
            )
        }
    }
}
