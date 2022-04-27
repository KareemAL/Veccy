package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.veccy.math.Matrix3;
import at.fhhgb.mtd.gop.veccy.math.TransformFactory;
import at.fhhgb.mtd.gop.veccy.math.Vector3;
import javafx.scene.canvas.GraphicsContext;

public class Path extends Shape {

    private Vector3[] Pathpoints = new Vector3[0];

    public Path(int x, int y) {
        super(x, y);
    }

    public Rectangle boundingBox() {
        double MaxX = Double.MIN_VALUE;
        double MaxY = Double.MIN_VALUE;
        double MinX = Double.MIN_VALUE;
        double MinY = Double.MIN_VALUE;
        for (int i = 0; i < Pathpoints.length; i++) {
            if (i == 0) {
                MaxX = this.Pathpoints[i].getValues()[0];
                MaxY = this.Pathpoints[i].getValues()[1];
                MinX = this.Pathpoints[i].getValues()[0];
                MinY = this.Pathpoints[i].getValues()[1];
            }
            else {
                if (MinX > Pathpoints[i].getValues()[0]) {
                    MinX = Pathpoints[i].getValues()[0];
                }
                if (MinY > Pathpoints[i].getValues()[1]) {
                    MinY = Pathpoints[i].getValues()[1];
                }
                if (MaxX < Pathpoints[i].getValues()[0]) {
                    MaxX = Pathpoints[i].getValues()[0];
                }
                if (MaxY < Pathpoints[i].getValues()[1]) {
                    MaxY = Pathpoints[i].getValues()[1];
                }
            }
        }
        Rectangle rect = new Rectangle((int)MinX, (int)MinY, (int)MaxX - (int)MinX, (int)MaxY - (int)MinY);
        return rect;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        double[][] Pathcoords = getCoordinates();
        graphicsContext.strokePolygon(Pathcoords[0], Pathcoords[1], Pathcoords[0].length);
    }

    @Override
    public double[][] getCoordinates() {
        Vector3[] Cords = new Vector3[Pathpoints.length];
        double[][] edge = new double[2][Pathpoints.length];
        double[] savePoints = new double[3];
        savePoints[2] = 1;
        for (int i = 0; i < Pathpoints.length; i++) {
            edge[0][i] = this.Pathpoints[i].getValues()[0];
            edge[1][i] = this.Pathpoints[i].getValues()[1];
            savePoints[0] = edge[0][i];
            savePoints[1] = edge[1][i];
            Cords[i] = new Vector3(savePoints);
        }
        Matrix3 ToOrigin = TransformFactory.createTranslation(-getX(), -getY());
        Matrix3 FromOrigin = TransformFactory.createTranslation(getX(), getY());
        if (this.transform != null) {
            for (int i = 0; i < Pathpoints.length; i++) {
                Cords[i] = FromOrigin.mult(transform).mult(ToOrigin).mult(Cords[i]);
            }
        }
        for (int i = 0; i < Pathpoints.length; i++) {
            savePoints = Cords[i].getValues();
            edge[0][i] = savePoints[0];
            edge[1][i] = savePoints[1];
        }
        return edge;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Path @ ");
        sb.append(position.getValues()[0]);
        sb.append("/");
        sb.append(position.getValues()[1]);
        sb.append(" | vertecies: ");
        sb.append(Pathpoints.length);
        return sb.toString();
    }

    public void AddPoints(Vector3[] NewClick) {
        this.Pathpoints = joinPoints(this.Pathpoints, NewClick);
    }

    public Vector3[] joinPoints(Vector3[] A, Vector3[] B) {
        Vector3[] res = new Vector3[A.length + B.length];
        for (int i = 0; i < A.length; i++){
            res[i] = A[i];
        }
        for (int i = 0; i < B.length; i++){
            res[A.length + i] = B[i];
        }
        return res;
    }
}