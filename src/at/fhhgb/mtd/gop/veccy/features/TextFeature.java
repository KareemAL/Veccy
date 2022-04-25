package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Text;
import at.fhhgb.mtd.gop.veccy.view.BlockingTextInputDialog;

public class TextFeature implements NamedFeature {

    private CanvasModel tex;
    private boolean selected = false;
    private Text currenText;
    private int OriginX;
    private int OriginY;

    public TextFeature(CanvasModel point) {
        this.tex = point;
    }

    @Override
    public String getName() {
        return "Text";
    }

    @Override
    public void onSelect() {
        System.out.println("Selected Text");
        selected = true;
    }

    @Override
    public void onDeselect() {
        System.out.println("Deselected Text");
        selected = false;
    }

    @Override
    public void onMouseClick(int x, int y) {
        if (selected) {
            if (currenText == null) {
                OriginX = x;
                OriginY = y;
                currenText = new Text(x, y);
                currenText.setFillColor(tex.getCurrentFillColor());
                currenText.setStrokeColor(tex.getCurrentStrokeColor());
                currenText.SetText(BlockingTextInputDialog.requestTextInput());
                tex.addShape(currenText);
                currenText = null;
            }
        }
    }

    @Override
    public void onMouseDrag(int x, int y) {
    }
}