package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.math.Vector3;
import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Path;

public class PathFeature implements NamedFeature {

    private CanvasModel path;
    private boolean selected = false;
    private Path currentPath;

    public PathFeature(CanvasModel path) {
        this.path = path;
    }

    @Override
    public String getName() {
        return "Path";
    }

    @Override
    public void onSelect() {
        System.out.println("Selected Path");
        selected = true;
    }

    @Override
    public void onDeselect() {
        System.out.println("Deselected Path");
        if (selected) {
            if (currentPath != null) {
                path.addShape(currentPath);
                currentPath = null;
            }
        }
        selected = false;
    }

    @Override
    public void onMouseClick(int x, int y) {
        if (selected) {
            if (currentPath == null) {
                currentPath = new Path(x, y);
            }
            Vector3[] NewPoint = new Vector3[]{new Vector3(new double[]{(double)(x), (double)(y), 1.0})};
            currentPath.AddPoints(NewPoint);
            currentPath.setFillColor(path.getCurrentFillColor());
            currentPath.setStrokeColor(path.getCurrentStrokeColor());
            path.addShape(currentPath);
        }
    }

    @Override
    public void onMouseDrag(int x, int y) {
        if (selected) {
            if (currentPath == null) {
                //currentPolygon[0] = [x, y];
            }
        }
    }
}
