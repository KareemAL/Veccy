package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Circle;
import at.fhhgb.mtd.gop.veccy.shapes.Rectangle;
import javafx.scene.paint.Color;

public class CircleFeature implements NamedFeature {

    @Override
    public String getName() {
        return "Circle";
    }

    private CanvasModel circ;
    private boolean selected = false;
    private Circle currentCircle;
    private int OriginX;
    private int OriginY;

    public CircleFeature(CanvasModel circle) {
        this.circ = circle;
    }

    @Override
    public void onSelect() {
        System.out.println("Selected Circle");
        selected = true;
    }

    @Override
    public void onDeselect() {
        System.out.println("Deselected Circle");
        selected = false;
    }

    @Override
    public void onMouseClick(int x, int y) {
        if(selected) {
            if (currentCircle != null) {
                currentCircle = null;
            }
        }
    }

    @Override
    public void onMouseDrag(int x, int y) {
        if (selected) {
            if (currentCircle == null) {
                OriginX = x;
                OriginY = y;
                currentCircle = new Circle(x, y, 0);
                currentCircle.setFillColor(circ.getCurrentFillColor());
                currentCircle.setStrokeColor(circ.getCurrentStrokeColor());
                circ.addShape(currentCircle);
            }
            else {
                currentCircle.setRadius((int)(Math.sqrt((x-OriginX)^2+(y-OriginY)^2)));
            }
        }
    }
}
