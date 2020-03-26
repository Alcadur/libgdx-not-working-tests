package pl.chamsterdev.mazeslayers.screens.mainScreen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import pl.chamsterdev.mazeslayers.screens.BaseScreen
import pl.chamsterdev.mazeslayers.shared.Asset

class MainScreen : BaseScreen() {
    private val menuTable = Table()
    private val stage = Stage()
    private val gameSelector = MenuSelector()
    private val characterSelector = MenuSelector()
    private val startButton: TextButton

    init {
        this.inject()
        Gdx.input.inputProcessor = stage
        stage.isDebugAll = true
        menuTable.setFillParent(true)

        setupGameSelector()
        setupCharacterSelector()
        startButton = createStartButton()

        menuTable.add(gameSelector)
        menuTable.row().padTop(100f)
        menuTable.add(characterSelector)
        menuTable.row()
        menuTable.add(startButton)

        stage.addActor(menuTable)
    }

    private fun setupGameSelector() {
        gameSelector.add(Asset.GAME_ESCAPE)
                .add(Asset.GAME_TOWER)
                .add(Asset.GAME_MANSIONS)
    }

    private fun setupCharacterSelector() {
        characterSelector.add(Asset.CHARACTER_ICON_VAMPIRE)
                .add(Asset.CHARACTER_ICON_THIEF)
                .add(Asset.CHARACTER_ICON_PALADIN)
                .add(Asset.CHARACTER_ICON_MAG)
    }

    private fun createStartButton(): TextButton {
        val style = TextButton.TextButtonStyle()
        style.font = BitmapFont(Gdx.files.internal("font.fnt"))
        style.font.region.texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)
        style.font.data.scale(3.5f)
        return TextButton("Start", style)
    }

    override fun render(delta: Float) {
        super.render(delta)
        stage.draw()
        stage.act()
    }
}
