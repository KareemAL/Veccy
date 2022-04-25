package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Point;
import at.fhhgb.mtd.gop.veccy.shapes.Rectangle;

public class PointFeature implements NamedFeature {

    private CanvasModel poin;
    private boolean selected = false;
    private Point currentPoint;
    private int OriginX;
    private int OriginY;

    public PointFeature(CanvasModel point) {
        this.poin = point;
    }

    @Override
    public String getName() {
        return "Point";
    }

    @Override
    public void onSelect() {
        System.out.println("Selected Point");
        selected = true;
    }

    @Override
    public void onDeselect() {
        System.out.println("Deselected Point");
        selected = false;
    }

    @Override
    public void onMouseClick(int x, int y) {
        if (selected) {
            if (currentPoint == null) {
                OriginX = x;
                OriginY = y;
                currentPoint = new Point(x, y);
                currentPoint.setFillColor(poin.getCurrentFillColor());
                currentPoint.setStrokeColor(poin.getCurrentStrokeColor());
                poin.addShape(currentPoint);
                currentPoint = null;
            }
        }
    }

    @Override
    public void onMouseDrag(int x, int y) {
        if (selected) {
            if (currentPoint == null) {
                OriginX = x;
                OriginY = y;
                currentPoint = new Point(x, y);
                currentPoint.setFillColor(poin.getCurrentFillColor());
                currentPoint.setStrokeColor(poin.getCurrentStrokeColor());
                poin.addShape(currentPoint);
                currentPoint = null;
            }
        }
    }
}