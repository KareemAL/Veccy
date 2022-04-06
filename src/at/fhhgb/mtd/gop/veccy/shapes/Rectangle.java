// Author Kareem Al-Khalily s2110238002 13.03.2022

package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.veccy.math.Matrix3;
import at.fhhgb.mtd.gop.veccy.math.TransformFactory;
import at.fhhgb.mtd.gop.veccy.math.Vector3;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

//    public Rectangle(int x, int y, int width, int height, Color c) {
//        super(x, y);
//        this.width = width;
//        this.height = height;
//        super.setFillColor(c);
//    }

    public int area() {
        int rectangle_area;

        rectangle_area = width * height;

        return rectangle_area;
    }

    public Rectangle boundingBox() {
        Rectangle rect = new Rectangle(super.getX(),super.getY(),width,height);
        return rect;
    }



    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isOverlapping(Rectangle other) {
        return super.getX() < other.getX() + other.width && super.getX() + width > other.getX() && super.getY() < other.getY() + other.height && super.getY() + height > other.getY();
    }

    public boolean equals(Rectangle other) {
        return other.getX() == getX() && other.getY() == getY() && other.getWidth() == getWidth() && other.getHeight() == getHeight();
    }

    private double[][] getCoordinates() {
        Vector3[] Coord = new Vector3[4];
        double[][] corners = new double[2][4];
        double[] savePoints = new double[3];
        savePoints[2] = 1;
        corners[0][0] = getX();
        corners[0][1] = getX();
        corners[0][2] = getX() + getWidth();
        corners[0][3] = getX() + getWidth();
        corners[1][0] = getY();
        corners[1][1] = getY() + getHeight();
        corners[1][2] = getY() + getHeight();
        corners[1][3] = getY();
        for (int i = 0; i < 4; i++) {
            savePoints[0] = corners[0][i];
            savePoints[1] = corners[1][i];
            Coord[i] = new Vector3(savePoints);
        }
        Matrix3 ToOrigin = TransformFactory.createTranslation(-(getX() + getWidth()/2), -(getY() + getHeight()/2));
        Matrix3 FromOrigin = TransformFactory.createTranslation(getX() + getWidth()/2, getY() + getHeight()/2);
        if (this.transform != null) {
            for (int i = 0; i < 4; i++) {
                Coord[i] = FromOrigin.mult(transform).mult(ToOrigin).mult(Coord[i]);
            }
        }
        for (int i = 0; i < 4; i++) {
            savePoints = Coord[i].getValues();
            corners[0][i] = savePoints[0];
            corners[1][i] = savePoints[1];
        }
        return corners;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Rectangle) {
            Rectangle other = (Rectangle) obj;
            return other.position.getValues()[0] == position.getValues()[0] && other.position.getValues()[1] == position.getValues()[1] &&
                    other.fillColor.getBrightness() == fillColor.getBrightness() &&
                    other.fillColor.getHue() == fillColor.getHue() &&
                    other.fillColor.getSaturation() == fillColor.getSaturation() &&
                    other.getHeight() == getHeight() && other.getWidth() == getWidth();
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Rectangle @ ");
        sb.append(position.getValues()[0]);
        sb.append("/");
        sb.append(position.getValues()[1]);
        sb.append(" Width: ");
        sb.append(getWidth());
        sb.append(" Height: ");
        sb.append(getHeight());
        return sb.toString();
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        double[][] coordinates = getCoordinates();
        graphicsContext.fillPolygon(coordinates[0], coordinates[1], coordinates[0].length);
        graphicsContext.strokePolygon(coordinates[0], coordinates[1], coordinates[0].length);

//        graphicsContext.setFill(c);
//        graphicsContext.fillRect(this.x, this.y, this.width, this.height);
    }
}