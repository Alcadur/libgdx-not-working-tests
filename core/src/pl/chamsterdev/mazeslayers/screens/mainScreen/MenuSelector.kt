package pl.chamsterdev.mazeslayers.screens.mainScreen

import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.Touchable
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import pl.chamsterdev.mazeslayers.dagger.DI
import pl.chamsterdev.mazeslayers.shared.Asset
import pl.chamsterdev.mazeslayers.shared.AssetsHelper
import pl.chamsterdev.mazeslayers.shared.FontService
import javax.inject.Inject

class MenuSelector (
        private val selectionWidth: Float = 500f,
        private val selectionHeight: Float = selectionWidth
) : Table() {

    private val leftArrow: Image
    private val rightArrow: Image
    private val buttonSize = 200f

    private var currentSelectionIndex = 0

    @Inject
    lateinit var fontService: FontService

    @Inject
    lateinit var assetsHelper: AssetsHelper

    private val selectTypes: MutableSet<SelectType> = mutableSetOf()

    init {
        touchable = Touchable.enabled
        DI.shared.inject(this)

        leftArrow = buildNavigateButton(Asset.LEFT_ARROW, ::showPrev)
        rightArrow = buildNavigateButton(Asset.RIGHT_ARROW, ::showNext)

        super.add().colspan(3)
        row()
        addButton(leftArrow)
        super.add().width(selectionWidth).height(selectionHeight).expandX()
        addButton(rightArrow)
    }

    private fun addButton(image: Image) {
        super.add(image).width(buttonSize).height(buttonSize)
    }

    private fun update() {
        if (selectTypes.size > 0) {
            val selectedElement: SelectType = selectTypes.elementAt(currentSelectionIndex)
            cells[0].setActor<Label>(Label(selectedElement.title, fontService.createLabelStyleWithFont(3f)))
             cells[2].setActor<Image>(selectedElement.image)
        }
    }

    fun add(asset: Asset, title: String): MenuSelector {
        selectTypes.add(
            SelectType(
                assetsHelper.getImageFromAsset(asset),
                title
            )
        )
        update()
        return this
    }

    private fun buildNavigateButton(asset: Asset, clickAction: () -> Unit): Image {
        val image = assetsHelper.getImageFromAsset(asset)
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

    data class SelectType(val image: Image, val title: String)
}
