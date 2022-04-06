package at.fhhgb.mtd.gop.veccy.shapes;

import at.fhhgb.mtd.gop.veccy.math.Matrix3;
import at.fhhgb.mtd.gop.veccy.math.Vector3;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Shape implements DrawableShape {

    protected Vector3 position;
    protected Matrix3 transform;
    protected Color fillColor = Color.WHITE;
    protected Color strokeColor = Color.WHITE;
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
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
    public void draw(GraphicsContext graphicsContext) {     // Setzt die fillColor und strokeColor am ‚graphicsContext‘
        graphicsContext.setFill(fillColor);
        graphicsContext.setStroke(strokeColor);

//        super.draw(graphicsContext);
//        double[][] coordinates = getCoordinates();
//        graphicsContext.fillPolygon(coordinates[0], coordinates[1], coordinates[0].length);
//        graphicsContext.strokePolygon(coordinates[0], coordinates[1],
//                coordinates[0].length);
    }
}