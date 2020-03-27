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
    private val mazeTypeSelector = MenuSelector()

    init {
        this.inject()
        Gdx.input.inputProcessor = stage
        stage.isDebugAll = true
        menuTable.setFillParent(true)

        setupGameSelector()
        setupCharacterSelector()
        setupMazeTypeSelector()
        startButton = createStartButton()
        setupMainTable()

        stage.addActor(menuTable)
    }

    private fun setupGameSelector() {
        gameSelector.add(Asset.GAME_ESCAPE, "Escape")
                .add(Asset.GAME_TOWER, "Tower")
                .add(Asset.GAME_MANSIONS, "Mansion")
    }

    private fun setupCharacterSelector() {
        characterSelector.add(Asset.CHARACTER_ICON_VAMPIRE, "Vampire")
                .add(Asset.CHARACTER_ICON_THIEF, "Thief")
                .add(Asset.CHARACTER_ICON_PALADIN, "Paladin")
                .add(Asset.CHARACTER_ICON_MAG, "Mag")
    }

    private fun setupMazeTypeSelector() {
        mazeTypeSelector.add(Asset.MAZE_TYPE_SQUARE, "Square")
    }

    private fun createStartButton(): TextButton {
        val style = TextButton.TextButtonStyle()
        style.font = BitmapFont(Gdx.files.internal("font.fnt"))
        style.font.region.texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear)
        style.font.data.scale(3.5f)
        return TextButton("Start", style)
    }

    private fun setupMainTable() {
        val rowTopPad = 75f

        menuTable.add(gameSelector)
        menuTable.row().padTop(rowTopPad)
        menuTable.add(characterSelector)
        menuTable.row().padTop(rowTopPad)
        menuTable.add(mazeTypeSelector)
        menuTable.row().padTop(rowTopPad)
        menuTable.add(startButton)
    }

    override fun render(delta: Float) {
        super.render(delta)
        stage.draw()
        stage.act()
    }
}
