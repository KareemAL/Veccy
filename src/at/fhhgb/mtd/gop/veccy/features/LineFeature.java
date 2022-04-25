package at.fhhgb.mtd.gop.veccy.features;

import at.fhhgb.mtd.gop.veccy.model.CanvasModel;
import at.fhhgb.mtd.gop.veccy.model.NamedFeature;
import at.fhhgb.mtd.gop.veccy.shapes.Circle;
import at.fhhgb.mtd.gop.veccy.shapes.Line;
import at.fhhgb.mtd.gop.veccy.shapes.Rectangle;
import javafx.scene.paint.Color;

import java.awt.*;

public class LineFeature implements NamedFeature {

    private CanvasModel lin;
    private boolean selected = false;
    private Line currentLine;
    private int OriginX = 0;
    private int OriginY = 0;

    public LineFeature(CanvasModel line) {
        this.lin = line;
    }

    @Override
    public String getName() {
        return "Line";
    }

    @Override
    public void onSelect() {
        System.out.println("Selected Line");
        selected = true;
    }

    @Override
    public void onDeselect() {
        System.out.println("Deselected Line");
        selected = false;
    }

    @Override
    public void onMouseClick(int i, int i1) {
        if (selected) {
            if (currentLine != null) {
                currentLine = null;
            }
        }
    }

    @Override
    public void onMouseDrag(int x, int y) {
        if (selected) {
            if (currentLine == null) {
                OriginX = x;
                OriginY = y;
                currentLine = new Line(x, y, 0, 0);
                currentLine.setStrokeColor(lin.getCurrentStrokeColor());
                currentLine.setFillColor(lin.getCurrentFillColor());
                lin.addShape(currentLine);
            }
            else {
                int x2 = x;
                int y2 = y;
                currentLine.setX2(x2);
                currentLine.setY2(y2);
            }
        }
    }
}
