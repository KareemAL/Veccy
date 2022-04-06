// Author Kareem Al-Khalily s2110238002 13.03.2022

package at.fhhgb.mtd.gop.veccy.shapes;


import at.fhhgb.mtd.gop.veccy.math.Matrix3;
import at.fhhgb.mtd.gop.veccy.math.TransformFactory;
import at.fhhgb.mtd.gop.veccy.math.Vector3;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {

    private int radius;
    private Color c;

    public Circle(int x, int y, int radius, Color c) {
        super(x, y);
        this.radius = radius;
        this.c = c;
    }

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
        super.setFillColor(c);
    }

    public int area() {
        double real_circle_area;

        real_circle_area = Math.PI * (radius*radius);
        int round_circle_area = (int) Math.round(real_circle_area);

        return round_circle_area;
    }

    public Rectangle boundingBox() {
        Rectangle rect = new Rectangle(super.getX()-radius,super.getY()-radius,radius*2,radius*2);
        return rect;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    private double[][] getCoordinates() {
        int Circleres = 32;
        Vector3[] Cords = new Vector3[Circleres];
        double[][] edge = new double[2][Circleres];
        double[] savePoints = new double[3];
        savePoints[2] = 1;
        for (int i = 0; i < Circleres; i++) {
            savePoints[0] = getX() + getRadius() * Math.cos(i*(2*Math.PI)/Circleres);
            savePoints[1] = getY() + getRadius() * Math.sin(i*(2*Math.PI)/Circleres);
            Cords[i] = new Vector3(savePoints);
        }
        Matrix3 ToOrigin = TransformFactory.createTranslation(-getX(), -getY());
        Matrix3 FromOrigin = TransformFactory.createTranslation(getX(), getY());
        if (this.transform != null) {
            for (int i = 0; i < Circleres; i++) {
                Cords[i] = FromOrigin.mult(transform).mult(ToOrigin).mult(Cords[i]);
            }
        }
        for (int i = 0; i < Circleres; i++) {
            savePoints = Cords[i].getValues();
            edge[0][i] = savePoints[0];
            edge[1][i] = savePoints[1];
        }
        return edge;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Circle) {
            Circle other = (Circle) obj;
            return other.position.getValues()[0] == position.getValues()[0] && other.position.getValues()[1] == position.getValues()[1] &&
                    other.fillColor.getBrightness() == fillColor.getBrightness() &&
                    other.fillColor.getHue() == fillColor.getHue() &&
                    other.fillColor.getSaturation() == fillColor.getSaturation() &&
                    other.radius == radius;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Circle @ ");
        sb.append(position.getValues()[0]);
        sb.append("/");
        sb.append(position.getValues()[1]);
        sb.append(" Radius: ");
        sb.append(radius);
        return sb.toString();
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        double[][] coordinates = getCoordinates();
        graphicsContext.fillPolygon(coordinates[0], coordinates[1], coordinates[0].length);
        graphicsContext.strokePolygon(coordinates[0], coordinates[1], coordinates[0].length);
    }
}