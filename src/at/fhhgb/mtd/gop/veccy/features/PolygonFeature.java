package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.math.Vector3;
import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Line;
import at.fhhgb.mtd.gop.veccy.shapes.Polygon;

public class PolygonFeature implements NamedFeature {

    private CanvasModel poly;
    private boolean selected = false;
    private Polygon currentPolygon;

    public PolygonFeature(CanvasModel polygon) {
        this.poly = polygon;
    }

    @Override
    public String getName() {
        return "Polygon";
    }

    @Override
    public void onSelect() {
        System.out.println("Selected Polygon");
        selected = true;
    }

    @Override
    public void onDeselect() {
        System.out.println("Deselected Polygon");
        if (selected) {
            if (currentPolygon != null) {
                currentPolygon = null;
            }
        }
        selected = false;
    }

    @Override
    public void onMouseClick(int x, int y) {
        if (selected) {
            if (currentPolygon == null) {
                currentPolygon = new Polygon(x, y);
                currentPolygon.setFillColor(poly.getCurrentFillColor());
                currentPolygon.setStrokeColor(poly.getCurrentStrokeColor());
                poly.addShape(currentPolygon);
            }
            Vector3[] NewPoint = new Vector3[]{new Vector3(new double[]{(double)(x), (double)(y), 1.0})};
            currentPolygon.AddPoints(NewPoint);
        }
    }

    @Override
    public void onMouseDrag(int x, int y) {
        if (selected) {
            if (currentPolygon == null) {
                //currentPolygon[0] = [x, y];
            }
        }
    }
}
