package pl.chamsterdev.mazeslayers.shared

enum class Asset (val path: String){
    LOGO("maze-slayers-splash-screen.png");

    fun getValuesAsSet(): Set<Asset> {
       return setOf(
               LOGO
       )
    }
}
