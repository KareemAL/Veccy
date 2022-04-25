package at.fhhgb.mtd.gop.veccy.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Point extends Shape{

    private int x;
    private int y;

    public Point(int x, int y) {
        super(x, y);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public double[][] getCoordinates() {
        double[][] pointCoords = new double[2][1];
        pointCoords[0][0] = super.getX();
        pointCoords[1][0] = super.getY();
        return pointCoords;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        graphicsContext.fillOval(super.getX(), super.getY(), 3,3 );
    }
}