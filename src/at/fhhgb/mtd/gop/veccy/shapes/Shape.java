package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.veccy.math.Matrix3;
import at.fhhgb.mtd.gop.veccy.math.Vector3;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape implements DrawableShape {

    protected Vector3 position;
    protected Matrix3 transform;
    protected Color fillColor = Color.WHITE;
    protected Color strokeColor = Color.WHITE;
    private boolean isSelected = false;
    int[] positionToCoordsArray;

    public void posVectorToCoords () {
        for (int i = 0; i < 2; i++) {
            positionToCoordsArray[i] = (int) position.getValues()[0];
        }
    }

    public void setX(int x) {
        this.position = new Vector3(new double[]{x, getY(), 1.0});
    }

    public void setY(int y) {
        this.position = new Vector3(new double[]{getX(), y, 1.0});
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean getSelected() {
        return isSelected;
    }

    public int getX() {
        return (int)position.getValues()[0];
    }

    public int getY() {
        return (int)position.getValues()[1];
    }

    public Shape(int x, int y) {
        this.position = new Vector3(new double[]{x, y, 1.0});
    }

    public void setFillColor(Color c) {
        fillColor = c;
    }

    public void setStrokeColor(Color c) {
        strokeColor = c;
    }

    public void setTransform(Matrix3 transform) {       // Setzt die 'transform' Instanzvariable
        this.transform = transform;
    }

    public abstract double[][] getCoordinates();

    public Rectangle getBoundingBox() {
        double MinX = getCoordinates()[0][0];
        double MinY = getCoordinates()[1][0];
        double MaxX = getCoordinates()[0][0];
        double MaxY = getCoordinates()[1][0];
        Rectangle ShapeBoundingBox;

        for (int i = 0; i < getCoordinates()[0].length; i++) {
            if (getCoordinates()[0][i] < MinX) {
                MinX = getCoordinates()[0][i];
            }
        }
        for (int i = 0; i < getCoordinates()[1].length; i++) {
            if (getCoordinates()[1][i] < MinY) {
                MinY = getCoordinates()[1][i];
            }
        }
        for (int i = 0; i < getCoordinates()[1].length; i++) {
            if (getCoordinates()[1][i] > MaxY) {
                MaxY = getCoordinates()[1][i];
            }
        }
        for (int i = 0; i < getCoordinates()[0].length; i++) {
            if (getCoordinates()[0][i] > MaxX) {
                MaxX = getCoordinates()[0][i];
            }
        }
        ShapeBoundingBox = new Rectangle((int) MinX,(int) MinY,(int)(MaxX-MinX),(int)(MaxY-MinY));
        return ShapeBoundingBox;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Shape) {
            Shape other = (Shape) obj;
            return other.position.getValues()[0] == position.getValues()[0] && other.position.getValues()[1] == position.getValues()[1] &&
                    other.fillColor.getBrightness() == fillColor.getBrightness() &&
                    other.fillColor.getHue() == fillColor.getHue() &&
                    other.fillColor.getSaturation() == fillColor.getSaturation();
        }
        return false;
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Unknown Shape @ ");
        sb.append(position.getValues()[0]);
        sb.append("/");
        sb.append(position.getValues()[1]);
        return sb.toString();
    }

        @Override
    public void draw(GraphicsContext graphicsContext) {
        // Zeichne eine Bounding Box, sofern das Shape selektiert ist
        if(getSelected()) {
            Rectangle bb = getBoundingBox();
            graphicsContext.setStroke(Color.CYAN);
            graphicsContext.strokeRect(bb.getX(), bb.getY(),
                    bb.getWidth(), bb.getHeight());
        }

        // Setzt die fillColor und strokeColor am ‚graphicsContext‘
        graphicsContext.setFill(fillColor);
        graphicsContext.setStroke(strokeColor);

//        super.draw(graphicsContext);
//        double[][] coordinates = getCoordinates();
//        graphicsContext.fillPolygon(coordinates[0], coordinates[1], coordinates[0].length);
//        graphicsContext.strokePolygon(coordinates[0], coordinates[1],
//                coordinates[0].length);
    }
}