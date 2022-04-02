// Author Kareem Al-Khalily s2110238002 13.03.2022

package at.fhhgb.mtd.gop.veccy.shapes;


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
        this.c = Color.rgb(100, 100, 100);
    }

    public int area() {
        double real_circle_area;

        real_circle_area = Math.PI * (radius*radius);
        int round_circle_area = (int) Math.round(real_circle_area);

        return round_circle_area;
    }

    public Rectangle boundingBox() {
        Rectangle rect = new Rectangle(super.getX()-radius,super.getY()-radius,radius*2,radius*2,c);
        return rect;
    }

    public int getRadius() {return radius;}

    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(c);
        graphicsContext.fillOval(this.getX(), this.getY(), this.radius*2, this.radius*2);
    }
}