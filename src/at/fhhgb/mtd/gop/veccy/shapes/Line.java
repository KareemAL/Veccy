// Author Kareem Al-Khalily s2110238002 13.03.2022

package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.veccy.math.Matrix3;
import at.fhhgb.mtd.gop.veccy.math.TransformFactory;
import at.fhhgb.mtd.gop.veccy.math.Vector3;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line extends Shape{

    private int x2;
    private int y2;

    public Line(int x1, int y1, int x2, int y2) {
        super(x1, y1);
        this.x2 = x2;
        this.y2 = y2;
    }

    public Rectangle boundingBox() {
        int BBox_x = Math.min(super.getX(), x2);
        int BBox_y = Math.min(super.getY(), y2);
        int BBox_width = Math.abs(x2 - super.getX());
        int BBox_height = Math.abs(y2 - super.getY());
        Rectangle rect = new Rectangle(BBox_x, BBox_y, BBox_width, BBox_height);
        return rect;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    @Override
    public double[][] getCoordinates() {
        Vector3[] Cords = new Vector3[2];
        double[][] edge = new double[2][2];
        edge[0][0] = this.getX();
        edge[1][0] = this.getY();
        edge[0][1] = this.x2;
        edge[1][1] = this.y2;
        Matrix3 ToOrigin = TransformFactory.createTranslation(-getX(), -getY());
        Matrix3 FromOrigin = TransformFactory.createTranslation(getX(), getY());
        if (this.transform != null) {
            for (int i = 0; i < 2; i++) {
                Cords[i] = FromOrigin.mult(transform).mult(ToOrigin).mult(Cords[i]);
            }
        }
        return edge;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Line @ ");
        sb.append(position.getValues()[0]);
        sb.append("/");
        sb.append(position.getValues()[1]);
        return sb.toString();
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        graphicsContext.strokeLine(super.getX(), super.getY(),this.x2, this.y2);
    }
}