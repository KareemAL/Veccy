// Author Kareem Al-Khalily s2110238002 13.03.2022

package at.fhhgb.mtd.gop.veccy.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line extends Shape{
    private int x2;
    private int y2;

    public Line(int x1, int y1, int x2, int y2, Color c) {
        super(x1, y1);
        this.x2 = x2;
        this.y2 = y2;
        super.setFillColor(c);
    }

    public Rectangle boundingBox() {
        int BBox_x = Math.min(super.getX(), x2);
        int BBox_y = Math.min(super.getY(), y2);
        int BBox_width = Math.abs(x2 - super.getX());
        int BBox_height = Math.abs(y2 - super.getY());
        Rectangle rect = new Rectangle(BBox_x, BBox_y, BBox_width, BBox_height);
        return rect;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
    }
}