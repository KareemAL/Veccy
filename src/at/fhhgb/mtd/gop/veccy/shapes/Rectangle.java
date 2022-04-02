// Author Kareem Al-Khalily s2110238002 13.03.2022

package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.veccy.math.Vector3;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {
    private int width;
    private int height;
    private Color c;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.c = Color.rgb(100, 100, 100);
    }

    public Rectangle(int x, int y, int width, int height, Color c) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.c = c;
    }

    public int area() {
        int rectangle_area;

        rectangle_area = width * height;

        return rectangle_area;
    }

    public Rectangle boundingBox() {
        Rectangle rect = new Rectangle(super.getX(),super.getY(),width,height,c);
        return rect;
    }



    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isOverlapping(Rectangle other) {
        return super.getX() < other.getX() + other.width && super.getX() + width > other.getX() && super.getY() < other.getY() + other.height && super.getY() + height > other.getY();
    }

    public boolean equals(Rectangle other) {
        return other.getX() == getX() && other.getY() == getY() && other.getWidth() == getWidth() && other.getHeight() == getHeight();
    }

    private double[][] getCoordinates() {
        Vector3 vector3 = new Vector3();
        return new double[][] {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
//        graphicsContext.setFill(c);
//        graphicsContext.fillRect(this.x, this.y, this.width, this.height);
    }
}