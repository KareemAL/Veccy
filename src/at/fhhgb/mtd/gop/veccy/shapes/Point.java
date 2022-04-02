package at.fhhgb.mtd.gop.veccy.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Point extends Shape{
    private Color c;

    public Point(int x, int y, Color c) {
        super(x, y);
        this.c = Color.rgb(100, 100, 100);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setStroke(c);
        graphicsContext.fillOval(this.getX(), this.getY(), 3, 3);
    }
}