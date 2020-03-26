package pl.chamsterdev.mazeslayers.shared

enum class Asset (val path: String){
    LOGO("maze-slayers-splash-screen.png"),
    LEFT_ARROW("main-screen/menu-arrow-left.png"),
    RIGHT_ARROW("main-screen/menu-arrow-right.png"),
    GAME_TOWER("main-screen/game-tower.png"),
    GAME_MANSIONS("main-screen/game-mansions.png"),
    GAME_ESCAPE("main-screen/game-escape.png"),
    CHARACTER_ICON_MAG("main-screen/character-icon-mag.png"),
    CHARACTER_ICON_PALADIN("main-screen/character-icon-paladin.png"),
    CHARACTER_ICON_THIEF("main-screen/character-icon-thief.png"),
    CHARACTER_ICON_VAMPIRE("main-screen/character-icon-vampire.png"),
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
                    CHARACTER_ICON_VAMPIRE
            )
        }
    }
}
