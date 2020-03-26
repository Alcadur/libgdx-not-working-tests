package pl.chamsterdev.mazeslayers.screens.mainScreen

import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Touchable
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import pl.chamsterdev.mazeslayers.dagger.DI
import pl.chamsterdev.mazeslayers.shared.Asset
import pl.chamsterdev.mazeslayers.shared.AssetsService
import javax.inject.Inject

class MenuSelector (
        private val selectionWidth: Float = 500f,
        private val selectionHeight: Float = selectionWidth
) : Table() {

    private val leftArrow: Image
    private val rightArrow: Image
    private val buttonSize = 200f

    @Inject()
    lateinit var assetsService: AssetsService
    private var currentSelectionIndex = 0

    private val selectTypes: MutableSet<Image> = mutableSetOf()

    init {
        touchable = Touchable.enabled
        DI.shared.inject(this)

        leftArrow = buildNavigateButton(Asset.LEFT_ARROW, ::showPrev)
        rightArrow = buildNavigateButton(Asset.RIGHT_ARROW, ::showNext)
        addButton(leftArrow)
        add().width(selectionWidth).height(selectionHeight).expandX()
        addButton(rightArrow)
    }

    private fun addButton(image: Image) {
        add(image).width(buttonSize).height(buttonSize)
    }

    private fun update() {
        if (selectTypes.size > 0) {
            cells[1].setActor<Image>(selectTypes.elementAt(currentSelectionIndex))
        }
    }

    fun add(asset: Asset): MenuSelector {
        selectTypes.add(Image(assetsService.getTexture(asset)))
        update()
        return this
    }

    private fun buildNavigateButton(asset: Asset, clickAction: () -> Unit): Image {
        val image = Image(assetsService.getTexture(asset))
        image.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                clickAction()
            }
        })
        return image
    }

    private fun showPrev() {
        currentSelectionIndex -= 1
        if (currentSelectionIndex < 0) {
            currentSelectionIndex = selectTypes.size - 1
        }

        update()
    }

    private fun showNext() {
        currentSelectionIndex += 1
        if (currentSelectionIndex >= selectTypes.size) {
            currentSelectionIndex = 0
        }

        update()
    }

    override fun draw(batch: Batch?, parentAlpha: Float) {
        validate()
        super.draw(batch, parentAlpha)
    }

    data class SelectType(val image: Image)
}
