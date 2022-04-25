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

    private Vector3[] LinePoints = new Vector3[0];

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
        Vector3[] Cords = new Vector3[LinePoints.length];
        double[][] edge = new double[2][LinePoints.length];
        double[] savePoints = new double[3];
        savePoints[2] = 1;
        for (int i = 0; i < LinePoints.length; i++) {
            edge[0][i] = this.LinePoints[i].getValues()[0];
            edge[1][i] = this.LinePoints[i].getValues()[1];
            savePoints[0] = edge[0][i];
            savePoints[1] = edge[1][i];
            Cords[i] = new Vector3(savePoints);
        }
        Matrix3 ToOrigin = TransformFactory.createTranslation(-getX(), -getY());
        Matrix3 FromOrigin = TransformFactory.createTranslation(getX(), getY());
        if (this.transform != null) {
            for (int i = 0; i < LinePoints.length; i++) {
                Cords[i] = FromOrigin.mult(transform).mult(ToOrigin).mult(Cords[i]);
            }
        }
        for (int i = 0; i < LinePoints.length; i++) {
            savePoints = Cords[i].getValues();
            edge[0][i] = savePoints[0];
            edge[1][i] = savePoints[1];
        }
        return edge;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        graphicsContext.strokeLine(super.getX(), super.getY(),this.x2, this.y2);
    }
}