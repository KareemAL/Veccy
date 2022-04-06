package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Rectangle;
import javafx.scene.paint.Color;

public class RectangleFeature implements NamedFeature {
    @Override
    public String getName() {
        return "Rectangle";
    }

    private CanvasModel rect;
    private boolean selected = false;
    private Rectangle currentRectangle = null;
    private int OriginX = 0;
    private int OriginY = 0;

    public RectangleFeature(CanvasModel rectangle) {
        this.rect = rectangle;
    }

    @Override
    public void onSelect() {
        System.out.println("Selected Rectangle");
        selected = true;
    }

    @Override
    public void onDeselect() {
        System.out.println("Deselected Rectangle");
        selected = false;
    }

    @Override
    public void onMouseClick(int x, int y) {
        if (selected) {
            if (currentRectangle != null) {
                currentRectangle = null;
            }
        }
    }

    @Override
    public void onMouseDrag(int x, int y) {
        if (selected) {
            if (currentRectangle == null) {
                OriginX = x;
                OriginY = y;
                currentRectangle = new Rectangle(x, y, 0, 0);
                currentRectangle.setFillColor(rect.getCurrentFillColor());
                currentRectangle.setStrokeColor(rect.getCurrentStrokeColor());
                rect.addShape(currentRectangle);
            }
            else {
                currentRectangle.setWidth(x-OriginX);
                currentRectangle.setHeight(y-OriginY);
            }

        }
    }
}
